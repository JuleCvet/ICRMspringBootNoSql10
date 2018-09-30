package org.ungur.clouddatastore.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.ungur.clouddatastore.model.UserAssignment;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@Service
public class UserAssignmentService {

	private final Logger log = LoggerFactory.getLogger(UserAssignmentService.class);

	@Autowired
	Datastore datastore;

	private KeyFactory userAssignmentKeyFactory;

	@PostConstruct
	public void initializeKeyFactories() {
		log.info("Initializing key factories");
		userAssignmentKeyFactory = datastore.newKeyFactory().setKind("UserAssignment");
	}

	public Entity createUserAssignment(UserAssignment userAssignment) {
		return datastore.put(createUserAssignmentEntity(userAssignment));
	}

	private Entity createUserAssignmentEntity(UserAssignment userAssignment) {
		Key key = userAssignmentKeyFactory.newKey(userAssignment.getUserAssignmentId());
		return Entity.newBuilder(key).set("id", userAssignment.getId())
				.set("assignmentId", userAssignment.getAssignmentId()).build();
	}

	private UserAssignment entityToUserAssignment(Entity userAssigmentEntity) {
		UserAssignment userAssignmentToReturn = new UserAssignment();

		Long userAssignmentId = userAssigmentEntity.getKey().getId();
		Long userId = userAssigmentEntity.getLong("id");
		Long assignmentId = userAssigmentEntity.getLong("assignmentId");

		userAssignmentToReturn.setUserAssignmentId(userAssignmentId);
		userAssignmentToReturn.setId(userId);
		userAssignmentToReturn.setAssignmentId(assignmentId);

		return userAssignmentToReturn;
	}

	public UserAssignment readUserAssignment(Long id) {
		try {
			Entity userAssigmentEntity = datastore.get(userAssignmentKeyFactory.newKey(id));
			return entityToUserAssignment(userAssigmentEntity);

		} catch (EntityNotFoundException e) {
		}
		return null;
	}

	public List<UserAssignment> readAllUserAssignments() {
		ArrayList<UserAssignment> userAssignments = new ArrayList<>();
		Query<Entity> query = Query.newEntityQueryBuilder().setKind("UserAssignment").build();
		QueryResults<Entity> results = datastore.run(query);
		while (results.hasNext()) {
			Entity currentEntity = results.next();
			UserAssignment userAssignment = entityToUserAssignment(currentEntity);
			userAssignments.add(userAssignment);
		}
		return userAssignments;
	}

	@Async
	public Entity updateUserAssignment(UserAssignment userAssignment) {
		return datastore.put(createUserAssignmentEntity(userAssignment));
	}

	@Async
	public void deleteUserAssignment(Long id) {
		datastore.delete(userAssignmentKeyFactory.newKey(id));
	}

}

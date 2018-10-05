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
import org.ungur.clouddatastore.model.Assignment;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@Service
public class AssignmentService {

	private final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	Datastore datastore;

	private KeyFactory assignmentKeyFactory;

	@PostConstruct
	public void initializeKeyFactories() {
		log.info("Initializing key factories");
		assignmentKeyFactory = datastore.newKeyFactory().setKind("Assignment");
	}

	public Entity createAssignment(Assignment assignment) {
		return datastore.put(createAssignmentEntity(assignment));
	}

	private Entity createAssignmentEntity(Assignment assignment) {
		Key key = assignmentKeyFactory.newKey(assignment.getAssignmentId());
		return Entity.newBuilder(key).set("customer", assignment.getCustomer()).set("partner", assignment.getPartner())
				.set("role", assignment.getRole()).set("extend", assignment.getExtend())
				.set("startDate", assignment.getStartDate()).set("endDate", assignment.getEndDate())
				.set("comment", assignment.getComment()).build();
	}

	public Assignment readAssignment(Long id) {
		try {
			Entity assignmentEntity = datastore.get(assignmentKeyFactory.newKey(id));
			return entityToAssignment(assignmentEntity);

		} catch (EntityNotFoundException e) {
		}
		return null;
	}

	private Assignment entityToAssignment(Entity assignmentEntity) {

		Assignment assignmentToReturn = new Assignment();

		Long assignmentId = assignmentEntity.getKey().getId();
		String assignmentCustomer = assignmentEntity.getString("customer");
		String assignmentPartner = assignmentEntity.getString("partner");
		String assignmentRole = assignmentEntity.getString("role");
		String assignmentExtend = assignmentEntity.getString("extend");
		String assignmentStartDate = assignmentEntity.getString("startDate");
		String assignmentEndDate = assignmentEntity.getString("endDate");
		String assignmentComment = assignmentEntity.getString("comment");

		assignmentToReturn.setAssignmentId(assignmentId);
		assignmentToReturn.setCustomer(assignmentCustomer);
		assignmentToReturn.setPartner(assignmentPartner);
		assignmentToReturn.setRole(assignmentRole);
		assignmentToReturn.setExtend(assignmentExtend);
		assignmentToReturn.setStartDate(assignmentStartDate);
		assignmentToReturn.setEndDate(assignmentEndDate);
		assignmentToReturn.setComment(assignmentComment);

		return assignmentToReturn;
	}

	public List<Assignment> readAllAssignments() {
		ArrayList<Assignment> assignments = new ArrayList<Assignment>();
		Query<Entity> query = Query.newEntityQueryBuilder().setKind("Assignment").build();
		QueryResults<Entity> results = datastore.run(query);
		while (results.hasNext()) {
			Entity currentEntity = results.next();
			Assignment assignment = entityToAssignment(currentEntity);
			assignments.add(assignment);
		}
		return assignments;

	}

	@Async
	public Entity updateAssignment(Assignment assignment) {
		return datastore.put(createAssignmentEntity(assignment));
	}

	@Async
	public void deleteAssignment(Long id) {
		datastore.delete(assignmentKeyFactory.newKey(id));
	}
}

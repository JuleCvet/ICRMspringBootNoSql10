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
import org.ungur.clouddatastore.model.Role;
import org.ungur.clouddatastore.model.User;

import com.google.cloud.datastore.Batch;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@Service
public class UserService {

	private final Logger log = LoggerFactory.getLogger(UserService.class);

	@Autowired
	Datastore datastore;

	private KeyFactory userKeyFactory;

	@PostConstruct
	public void initializeKeyFactories() {
		log.info("Initializing key factories");
		userKeyFactory = datastore.newKeyFactory().setKind("User");
	}

	public Entity createUser(User user) {
		return datastore.put(createUserEntity(user));
	}

	public User readUser(Long id) {
		try {
			Entity userEntity = datastore.get(userKeyFactory.newKey(id));
			return entityToUser(userEntity);

		} catch (EntityNotFoundException e) {
		}
		return null;
	}

	/*
	 * public String readAllUsersJule(String id) { Entity usersEntity =
	 * datastore.get(userKeyFactory.newKey(id)); return
	 * usersEntity.getString("fullName"); }
	 */

	public List<User> readAllUsers() {
		ArrayList<User> users = new ArrayList<User>();
		Query<Entity> query = Query.newEntityQueryBuilder().setKind("User").build();
		QueryResults<Entity> results = datastore.run(query);
		while (results.hasNext()) {
			Entity currentEntity = results.next();
			User user = entityToUser(currentEntity);
			users.add(user);
		}
		return users;
	}

	public User entityToUser(Entity userEntity) {
		User userToReturn = new User();

		Long userID = userEntity.getKey().getId();
		String userEmail = userEntity.getString("email");
		String userPassword = userEntity.getString("password");
		String userFullName = userEntity.getString("fullName");
		Boolean userIsDeleted = userEntity.getBoolean("isDeleted");

		userToReturn.setId(userID).setEmail(userEmail).setPassword(userPassword).setFullName(userFullName)
				.setIsDeleted(userIsDeleted);

		return userToReturn;
	}

	private Entity createUserEntity(User user) {
		Key key = userKeyFactory.newKey(user.getId());
		return Entity.newBuilder(key).set("email", user.getEmail()).set("password", user.getPassword())
				.set("fullName", user.getFullName()).set("isDeleted", user.getIsDeleted()).build();
	}

	@Async
	public Entity updateUser(User user) {
		return datastore.put(createUserEntity(user));
	}

	@Async
	public void deleteUser(Long id) {
		datastore.delete(userKeyFactory.newKey(id));
	}

	public Batch.Response createUser(Role users) {
		Batch batch = datastore.newBatch();
		for (User user : users.getUsers()) {
			batch.put(createUserEntity(user));
		}
		return batch.submit();
	}
}

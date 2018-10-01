package org.ungur.clouddatastore.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {

	@NotNull
	private Long id;

	@NotNull
	@Email
	private String email;

	private String password;

	@NotBlank
	private String fullName;

	private Boolean isDeleted;

	private List<Assignment> assigments;
	// Display a list of current or upcoming assignments. User must be able to
	// select more than one.
	// The underlying method saves a list of the assignment ids (UUID) to the data
	// store.
	// If in edit mode, the selection component must have currently selected ids
	// marked.
	// To be elaborated, the page should display all active assignments
	// (offers and/or agreements with agreements first). It must also be possible to
	// view all historical
	// assignments, but only if the user selects it…

	public User() {
	}

	public User(String email, String password, String fullName, Boolean isDeleted, List<Assignment> assigments) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.isDeleted = isDeleted;
		this.assigments = assigments;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getId() {
		return id;
	}

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public User setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public List<Assignment> getAssigments() {
		return assigments;
	}

	public void setAssigments(List<Assignment> assigments) {
		this.assigments = assigments;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, email=%s, password=%s, fullName=%s, isDeleted=%s, assigments=%s]", id, email,
				password, fullName, isDeleted, assigments);
	}

}

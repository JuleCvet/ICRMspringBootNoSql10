package org.ungur.clouddatastore.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {

    @NotNull
    private Long id;

    @NotNull
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;
    
    private List<Assignment> assigments;
//Display a list of current or upcoming assignments. User must be able to select more than one. 
//The underlying method saves a list of the assignment ids (UUID) to the data store. 
//If in edit mode, the selection component must have currently selected ids marked. 
//To be elaborated, the page should display all active assignments
//(offers and/or agreements with agreements first). It must also be possible to view all historical 
//assignments, but only if the user selects it… 

    public User() {}

    public User(Long id, String email, String password, String fullName, List<Assignment> assigments) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.assigments = assigments;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName + 
				", assigments=" + assigments + "]";
	}
}

package org.ungur.clouddatastore.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Role {

    @NotNull
    @Valid
    private List<User> users;
    
    private String name;

    public Role() {
    }

    public List<User> getUsers() {
        return users;
    }

    public Role setUsers(List<User> users) {
        this.users = users;
        return this;
    }

	public String getName() {
		return name;
	}
}

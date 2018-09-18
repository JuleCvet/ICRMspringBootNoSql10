package org.ungur.clouddatastore.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BatchUser {

	@NotNull
    @Valid
    private List<User> users;

    public BatchUser() {
    }

    public List<User> getUsers() {
        return users;
    }

    public BatchUser setUsers(List<User> users) {
        this.users = users;
        return this;
    }
}

package org.ungur.clouddatastore.model;

public class UserAssignment {

	private Long userAssignmentId;
	private Long id;
	private Long assignmentId;

	public UserAssignment() {
		super();
	}

	public UserAssignment(Long userAssignmentId, Long id, Long assignmentId) {
		super();
		this.userAssignmentId = userAssignmentId;
		this.id = id;
		this.assignmentId = assignmentId;
	}

	public Long getUserAssignmentId() {
		return userAssignmentId;
	}

	public void setUserAssignmentId(Long userAssignmentId) {
		this.userAssignmentId = userAssignmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	@Override
	public String toString() {
		return String.format("UserAssignment [userAssignmentId=%s, id=%s, assignmentId=%s]", userAssignmentId, id,
				assignmentId);
	}

}

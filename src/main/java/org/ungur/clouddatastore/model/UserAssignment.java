package org.ungur.clouddatastore.model;

public class UserAssignment {

	private Long userAssignmentId;
	private Long userID;
	private Long assignmentId;

	public UserAssignment() {
		super();
	}

	public UserAssignment(Long userAssignmentId, Long userID, Long assignmentId) {
		super();
		this.userAssignmentId = userAssignmentId;
		this.userID = userID;
		this.assignmentId = assignmentId;
	}

	public Long getUserAssignmentId() {
		return userAssignmentId;
	}

	public void setUserAssignmentId(Long userAssignmentId) {
		this.userAssignmentId = userAssignmentId;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	@Override
	public String toString() {
		return String.format("UserAssignment [userAssignmentId=%s, userID=%s, assignmentId=%s]", userAssignmentId,
				userID, assignmentId);
	}

}

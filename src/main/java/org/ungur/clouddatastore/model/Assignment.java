package org.ungur.clouddatastore.model;

//Assignment UI allows user to create new or edit existing assignments, 
//if an Assignment.id is part of the calling URL, edit mode is displayed and current data is 
//collected from the data store, otherwise create mode is enabled 
//(without data in any of the form fields). 

public class Assignment {

	private Long assignmentId;

	private String customer;
	private String partner;
	private String role;
	private String extend;
	private String startDate;
	private String endDate;
	private String comment;

	public Assignment() {
		super();
	}

	public Assignment(Long assignmentId, String customer, String partner, String role, String extend, String startDate,
			String endDate, String comment) {
		super();
		this.assignmentId = assignmentId;
		this.customer = customer;
		this.partner = partner;
		this.role = role;
		this.extend = extend;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comment = comment;
	}

	public Long getAssignmentId() {
		return assignmentId;
	}

	public void setAssignmentId(Long assignmentId) {
		this.assignmentId = assignmentId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Assignment [AssignmentId=" + assignmentId + ", customer=" + customer + ", partner=" + partner
				+ ", role=" + role + ", extend=" + extend + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", comment=" + comment + "]";
	}
}

package org.ungur.clouddatastore.model;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.google.api.client.util.DateTime;

//If agreement date is entered (and did not previously exist), Offer.status for the id is modified to
//Closed. If Agreement Date did exist and is cleared, and Offer.status is Closed, user must be forced 
//to modify status to either New or Rejected, an offer cannot be Closed and without Agreement at the 
//same time. 

//If Agreement Date is not set and Last Updated is edited, save the object as a new entry in the data store. 
//The web application must always display the version with the newest Last Updated value. 
//If Last Contact but not Last Updated is edited, replace the existing record in the data store. 
//gcloud beta auth application-default login

public class Offer {

	public static final String ISO_LOCAL_DATE_PATTERN = "yyyy-MM-dd";

	private Long offerId;

	@NotNull
	private Long assignmentID;
	// 2018-09-30
	// @JsonFormat(shape = Shape.STRING, pattern = ISO_LOCAL_DATE_PATTERN)
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	// @DateTimeFormat(iso = ISO.DATE)
	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @DateTimeFormat(pattern = "MM-dd-yyyy")
	// @DateTimeFormat(iso = ISO.DATE_TIME)
	private DateTime offerDate;

	// @JsonFormat(shape = Shape.STRING, pattern =
	// ISO_LOCAL_DATE_PATTERN)@DateTimeFormat(pattern = "MM/dd/yyyy")
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	// @DateTimeFormat(iso = ISO.DATE)
	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	// @DateTimeFormat(pattern = "MM-dd-yyyy")
	// @DateTimeFormat(iso = ISO.DATE_TIME)
	private DateTime lastUpdateDate;

	// @JsonFormat(shape = Shape.STRING, pattern = ISO_LOCAL_DATE_PATTERN)
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	// @DateTimeFormat(pattern = "dd-MM-yyyy")
	// @DateTimeFormat(iso = ISO.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	// @DateTimeFormat(pattern = "dd/MM/yyyy")
	// @DateTimeFormat(pattern = "MM/dd/yyyy")
	// @DateTimeFormat(pattern = "MM-dd-yyyy")
	// @DateTimeFormat(iso = ISO.DATE_TIME)
	private DateTime agreementDate;

	private String lastContact;
	private String comment;
	private StatusEnum status;

	public Offer() {
	}

	public Offer(Long offerId, Long assignmentID, DateTime offerDate, DateTime lastUpdateDate, DateTime agreementDate,
			String lastContact, String comment, StatusEnum status) {
		super();
		this.offerId = offerId;
		this.assignmentID = assignmentID;
		this.offerDate = offerDate;
		this.lastUpdateDate = lastUpdateDate;
		this.agreementDate = agreementDate;
		this.lastContact = lastContact;
		this.comment = comment;
		this.status = status;
	}

	public Long getAssignmentID() {
		return assignmentID;
	}

	public void setAssignmentID(Long assignmentID) {
		this.assignmentID = assignmentID;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getLastContact() {
		return lastContact;
	}

	public void setLastContact(String lastContact) {
		this.lastContact = lastContact;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public DateTime getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(DateTime offerDate) {
		this.offerDate = offerDate;
	}

	public DateTime getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(DateTime lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public DateTime getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(DateTime agreementDate) {
		this.agreementDate = agreementDate;
	}

	@Override
	public String toString() {
		return String.format(
				"Offer [offerId=%s, IdAssignment=%s, offerDate=%s, lastUpdateDate=%s, agreementDate=%s, lastContact=%s, comment=%s, status=%s]",
				offerId, assignmentID, offerDate, lastUpdateDate, agreementDate, lastContact, comment, status);
	}

}

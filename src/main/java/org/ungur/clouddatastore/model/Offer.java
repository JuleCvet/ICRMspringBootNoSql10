package org.ungur.clouddatastore.model;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import com.google.cloud.Date;


//If agreement date is entered (and did not previously exist), Offer.status for the id is modified to
//Closed. If Agreement Date did exist and is cleared, and Offer.status is Closed, user must be forced 
//to modify status to either New or Rejected, an offer cannot be Closed and without Agreement at the 
//same time. 
//If Agreement Date is not set and Last Updated is edited, save the object as a new entry in the data store. 
//The web application must always display the version with the newest Last Updated value. 
//If Last Contact but not Last Updated is edited, replace the existing record in the data store. 
//gcloud beta auth application-default login

public class Offer {
	
	@NotNull
	private Long offerId;
	
	private Date offerDate;
	private Date lastUpdateDate;
	private Date agreementDate;
	
	@NotBlank						
	private String lastContact;	
	private String comment;
	
	@NotBlank
	private StatusEnum status;
	
	public Offer() {}

	public Offer(Long offerId, Date offerDate, Date lastUpdateDate, Date agreementDate, String lastContact, String comment,
			StatusEnum status) {
		super();
		this.offerId = offerId;
		this.offerDate = offerDate;
		this.lastUpdateDate = lastUpdateDate;
		this.agreementDate = agreementDate;
		this.lastContact = lastContact;
		this.comment = comment;
		this.status = status;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
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

	public Date getAgreementDate() {
		return agreementDate;
	}

	public void setAgreementDate(Date agreementDate) {
		this.agreementDate = agreementDate;
	}

	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", offerDate=" + offerDate + ", lastUpdateDate=" + lastUpdateDate
				+ ", agreementDate=" + agreementDate + ", lastContact=" + lastContact + ", comment=" + comment
				+ ", status=" + status + "]";
	}
}


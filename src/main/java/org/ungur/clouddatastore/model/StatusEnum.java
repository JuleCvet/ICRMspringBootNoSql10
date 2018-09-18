package org.ungur.clouddatastore.model;

public enum StatusEnum {
	NEW, CLOSED, REJECTED;
}
//if Agreement exists (i.e. Agreement.agreementDate is not null and today is not past this date.
//an offer is consider New until Closed or Rejected. Default value for a new entry is New! 
//If not Assigned and there is an offer (that has not been rejected, i.e. Offer.state != “Rejected”)
//If not Assigned and not Offered


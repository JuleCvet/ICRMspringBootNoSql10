package org.ungur.clouddatastore.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ungur.clouddatastore.model.Offer;
import org.ungur.clouddatastore.model.StatusEnum;

import com.google.api.client.util.DateTime;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;

@Service
public class OfferService {

	private final Logger log = LoggerFactory.getLogger(OfferService.class);

	@Autowired
	private Datastore datastore;

	private KeyFactory offerKeyFactory;

	@PostConstruct
	public void initializeKeyFactories() {
		log.info("Initializing key factories");
		offerKeyFactory = datastore.newKeyFactory().setKind("Offer");
	}

	public Entity createOffer(Offer offer) {
		return datastore.put(createOfferEntity(offer));
	}

	private Entity createOfferEntity(Offer offer) {
		Key key = offerKeyFactory.newKey(offer.getOfferId());
		// System.out.println("offerId: " + offer.getOfferId());
		// System.out.println("assignmentID: " + offer.getAssignmentID());

		return Entity.newBuilder(key).set("assignmentID", offer.getAssignmentID())
				.set("offerDate", offer.getOfferDate().toString())
				.set("lastUpdateDate", offer.getLastUpdateDate().toString())
				.set("agreementDate", offer.getAgreementDate().toString()).set("lastContact", offer.getLastContact())
				.set("comment", offer.getComment()).set("status", offer.getStatus().toString()).build();

	}

	public Offer readOffer(Integer offerId) {
		try {
			Entity offerEntity = datastore.get(offerKeyFactory.newKey(offerId));
			return entityToOffer(offerEntity);

		} catch (EntityNotFoundException e) {
		}
		return null;
	}

	/*
	 * private Timestamp dateToTimeStamp(Date d) { Timestamp ts = new
	 * Timestamp(d.getTime()); return ts; }
	 */

	private Offer entityToOffer(Entity offerEntity) {

		Offer offerToReturn = new Offer();

		Long offerIdToReturn = offerEntity.getKey().getId();

		Long IdAssignmentToReturn = offerEntity.getLong("assignmentID");
		DateTime offerDateToReturn = DateTime.parseRfc3339(offerEntity.getString("offerDate"));
		// Timestamp offerDateToReturn = offerEntity.getTimestamp("offerDate");
		DateTime lastUpdateDateToReturn = DateTime.parseRfc3339(offerEntity.getString("lastUpdateDate"));
		DateTime agreementDateToReturn = DateTime.parseRfc3339(offerEntity.getString("agreementDate"));
		String lastContactToReturn = offerEntity.getString("lastContact");
		String commentToReturn = offerEntity.getString("comment");
		StatusEnum statusToReturn = StatusEnum.valueOf(offerEntity.getString("status"));

		offerToReturn.setOfferId(offerIdToReturn);
		offerToReturn.setAssignmentID(IdAssignmentToReturn);
		offerToReturn.setOfferDate(offerDateToReturn);
		offerToReturn.setLastUpdateDate(lastUpdateDateToReturn);
		offerToReturn.setAgreementDate(agreementDateToReturn);
		offerToReturn.setLastContact(lastContactToReturn);
		offerToReturn.setComment(commentToReturn);
		offerToReturn.setStatus(statusToReturn);

		return offerToReturn;
	}

	public List<Offer> readAllOffers() {
		List<Offer> offers = new ArrayList<>();
		Query<Entity> query = Query.newEntityQueryBuilder().setKind("Offer").build();
		QueryResults<Entity> results = datastore.run(query);
		while (results.hasNext()) {
			Entity currentEntity = results.next();
			Offer offer = entityToOffer(currentEntity);
			offers.add(offer);
		}
		return offers;
	}

	public Entity updateOffer(Offer offer) {
		return datastore.put(createOfferEntity(offer));
	}

	public void deleteOffer(Long id) {
		datastore.delete(offerKeyFactory.newKey(id));

	}
}

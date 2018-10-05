package org.ungur.clouddatastore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ungur.clouddatastore.model.Message;
import org.ungur.clouddatastore.model.Offer;
import org.ungur.clouddatastore.service.OfferService;

@Controller
public class OfferController {

	@Autowired
	private OfferService offerService;

	@RequestMapping(value = "/addNyOffer", method = RequestMethod.POST)
	public ResponseEntity<Message> addNyOffer(@Valid @RequestBody Offer offer) {
		offerService.createOffer(offer);

		return ResponseEntity.ok().body(new Message("New offer added"));
	}

}

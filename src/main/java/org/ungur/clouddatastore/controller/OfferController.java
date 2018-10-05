package org.ungur.clouddatastore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "/addOffer", method = RequestMethod.GET)
	public String addOffer(Model model) {
		model.addAttribute("addForm", new Offer());

		return "addOffer";
	}

	@RequestMapping(value = "/addOffer", method = RequestMethod.POST)
	public String addOffer(@RequestParam("offerDate") String offerDate,
			@RequestParam("lastUpdateDate") String lastUpdateDate, @RequestParam("agreementDate") String agreementDate,
			@ModelAttribute("addForm") Offer addForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "addOffer";
		}

		offerService.createOffer(addForm);
		return "redirect:/welcome";
	}

}

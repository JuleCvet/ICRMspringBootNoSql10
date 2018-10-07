package org.ungur.clouddatastore.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ungur.clouddatastore.model.Message;
import org.ungur.clouddatastore.model.Offer;
import org.ungur.clouddatastore.model.StatusEnum;
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
	public String addOffer(@ModelAttribute("addForm") Offer addForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "addOffer";
		}
		if (addForm.getAgreementDate() == null) {
			addForm.setStatus(StatusEnum.NEW);
		} else
			addForm.setStatus(StatusEnum.CLOSED);

		offerService.createOffer(addForm);
		return "redirect:/welcome";

	}

	@RequestMapping(value = "/getOneOfferByID/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Offer getOneOfferByID(@PathVariable("id") Long id) {
		Offer offerExampel = offerService.readOffer(id);

		return offerExampel;
	}

	@RequestMapping(value = "/getAllOffers", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Offer> getAllOffers() {
		ArrayList<Offer> offers = (ArrayList<Offer>) offerService.readAllOffers();

		return offers;
	}

	@RequestMapping(value = "/viewOffers", method = RequestMethod.GET)
	public ArrayList<Offer> viewOffers(Model model) {
		ArrayList<Offer> offers = (ArrayList<Offer>) offerService.readAllOffers();
		model.addAttribute("list", offers);

		return offers;
	}

	@RequestMapping(value = "/updateNyOffer", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateNyOffer(@Valid @RequestBody Offer offer) {
		offerService.updateOffer(offer);

		return ResponseEntity.ok().body(new Message("Offer has been updated"));
	}

	@RequestMapping(value = "/updateOffer/{id}", method = RequestMethod.GET)
	public String updateOffer(Model model, @PathVariable Long id) {
		model.addAttribute("updateForm", offerService.readOffer(id));

		return "updateOffer";
	}

	@RequestMapping(value = "/updateOffer/{id}", method = RequestMethod.POST)
	public String updateOffer(@ModelAttribute("updateForm") Offer updateForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updateOffer";
		}
		offerService.updateOffer(updateForm);

		return "redirect:/viewOffers";
	}

	@RequestMapping(value = "/deleteOffer/{id}", method = RequestMethod.GET)
	public String deleteOffer(@PathVariable Long id, Model model) {
		model.addAttribute("deleteForm", offerService.readOffer(id));

		return "deleteOffer";
	}

	@RequestMapping(value = "/deleteOffer/{id}", method = RequestMethod.POST)
	public String deleteOffer(@PathVariable Long id) {

		offerService.deleteOffer(id);

		return "redirect:/viewOffers";
	}

}

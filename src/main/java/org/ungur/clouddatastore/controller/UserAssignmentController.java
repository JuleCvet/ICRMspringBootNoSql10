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
import org.ungur.clouddatastore.model.UserAssignment;
import org.ungur.clouddatastore.service.UserAssignmentService;

@Controller
public class UserAssignmentController {

	@Autowired
	private UserAssignmentService userAssignmentService;

	@RequestMapping(value = "/addUserAssignment", method = RequestMethod.POST)
	public ResponseEntity<Message> addUserAssignment(@Valid @RequestBody UserAssignment userAssignment) {

		userAssignmentService.createUserAssignment(userAssignment);

		return ResponseEntity.ok().body(new Message("Created"));
	}

	@RequestMapping(value = "/createUserAssignment", method = RequestMethod.GET)
	public String createUserAssignment(Model model) {
		model.addAttribute("userAssignmentForm", new UserAssignment());

		return "createUserAssignment";
	}

	@RequestMapping(value = "/createUserAssignment", method = RequestMethod.POST)
	public String createUserAssignment(@ModelAttribute("userAssignmentForm") UserAssignment userAssignmentForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "createUserAssignment";
		}
		userAssignmentService.createUserAssignment(userAssignmentForm);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/getOneUserAssignment/{userAssignmentId}", method = RequestMethod.GET)
	@ResponseBody
	public UserAssignment getOneUserAssignment(@PathVariable("userAssignmentId") Long userAssignmentId) {
		UserAssignment userAssignmentExampel = userAssignmentService.readUserAssignment(userAssignmentId);

		return userAssignmentExampel;
	}

	@RequestMapping(value = "/getAllUserAssignments", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<UserAssignment> getAllUserAssignments() {
		ArrayList<UserAssignment> userAssignments = (ArrayList<UserAssignment>) userAssignmentService
				.readAllUserAssignments();

		return userAssignments;
	}

	@RequestMapping(value = "/updateOneUserAssignment", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateOneUserAssignment(@Valid @RequestBody UserAssignment userAssignment) {
		userAssignmentService.updateUserAssignment(userAssignment);

		return ResponseEntity.ok().body(new Message("Updated"));
	}

	@RequestMapping(value = "/deleteOneUserAssignment/{userAssignmentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Message> deleteOneUserAssignment(@PathVariable Long userAssignmentId) {
		userAssignmentService.deleteUserAssignment(userAssignmentId);

		return ResponseEntity.ok().body(new Message("Deleted"));
	}

}

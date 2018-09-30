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
import org.ungur.clouddatastore.service.AssignmentService;
import org.ungur.clouddatastore.service.UserAssignmentService;
import org.ungur.clouddatastore.service.UserService;

@Controller
public class UserAssignmentController {

	@Autowired
	private UserAssignmentService userAssignmentService;

	@Autowired
	private UserService userService;

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(value = "/addUserAssignment", method = RequestMethod.POST)
	public ResponseEntity<Message> addUserAssignment(@Valid @RequestBody UserAssignment userAssignment) {

		userAssignmentService.createUserAssignment(userAssignment);

		return ResponseEntity.ok().body(new Message("Created"));
	}

	@RequestMapping(value = "/create-userAssignment", method = RequestMethod.GET)
	public String create_userAssignment(Model model) {

		model.addAttribute("createUserAssignment", new UserAssignment());
		model.addAttribute("listUsers", userService.readAllUsers());
		model.addAttribute("listAssignments", assignmentService.readAllAssignments());

		return "create-userAssignment";
	}

	@RequestMapping(value = "/create-userAssignment", method = RequestMethod.POST)
	public String create_userAssignment(@ModelAttribute("createUserAssignment") UserAssignment createUserAssignment,
			BindingResult bindingResult, Model model) {

		// if (bindingResult.hasErrors()) {
		// return "create-userAssignment";
		// }

		UserAssignment ua = new UserAssignment();
		ua.setId((long) 1);
		ua.setAssignmentId((long) 2);
		userAssignmentService.createUserAssignment(ua);

		// return createUserAssignment.getId().toString();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/getOneUserAssignment/{userAssignmentId}", method = RequestMethod.GET)
	@ResponseBody
	public UserAssignment getOneUserAssignment(@PathVariable("userAssignmentId") Long userAssignmentId) {
		UserAssignment userAssignmentExampel = userAssignmentService.readUserAssignment(userAssignmentId);

		return userAssignmentExampel;
	}

	@RequestMapping(value = "/getUserAssignment/{userAssignmentId}", method = RequestMethod.GET)
	public UserAssignment getUserAssignment(@PathVariable("userAssignmentId") Long userAssignmentId) {
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

	@RequestMapping(value = "/viewAlllUserAssignments", method = RequestMethod.GET)
	public ArrayList<UserAssignment> viewAlllUserAssignments(Model model) {
		ArrayList<UserAssignment> userAssignments = (ArrayList<UserAssignment>) userAssignmentService
				.readAllUserAssignments();
		model.addAttribute("list", userAssignments);

		return userAssignments;
	}

	@RequestMapping(value = "/updateOneUserAssignment", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateOneUserAssignment(@Valid @RequestBody UserAssignment userAssignment) {
		userAssignmentService.updateUserAssignment(userAssignment);

		return ResponseEntity.ok().body(new Message("Updated"));
	}

	@RequestMapping(value = "/updateUserAssignment/{userAssignmentId}", method = RequestMethod.GET)
	public String updateUserAssignment(@PathVariable("userAssignmentId") Long userAssignmentId, Model model) {
		model.addAttribute("updateForm", userAssignmentService.readUserAssignment(userAssignmentId));

		return "updateUserAssignment";
	}

	@RequestMapping(value = "/updateUserAssignment/{userAssignmentId}", method = RequestMethod.POST)
	public String updateUserAssignment(@ModelAttribute("updateForm") UserAssignment updateForm,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updateUserAssignment";
		}
		userAssignmentService.updateUserAssignment(updateForm);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/deleteOneUserAssignment/{userAssignmentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Message> deleteOneUserAssignment(@PathVariable Long userAssignmentId) {
		userAssignmentService.deleteUserAssignment(userAssignmentId);

		return ResponseEntity.ok().body(new Message("Deleted"));
	}

	@RequestMapping(value = "/deleteUserAssignment/{userAssignmentId}", method = RequestMethod.GET)
	public String deleteUserAssignment(@PathVariable Long userAssignmentId, Model model) {

		model.addAttribute("deleteForm", userAssignmentService.readUserAssignment(userAssignmentId));

		return "deleteUserAssignment";
	}

	@RequestMapping(value = "/deleteUserAssignment/{userAssignmentId}", method = RequestMethod.POST)
	public String deleteUserAssignment(@PathVariable Long userAssignmentId) {

		userAssignmentService.deleteUserAssignment(userAssignmentId);

		return "redirect:/welcome";
	}
}

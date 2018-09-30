package org.ungur.clouddatastore.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

		userAssignmentService.createUserAssignment(userAssignment);// so postMan

		return ResponseEntity.ok().body(new Message("Created"));
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

}

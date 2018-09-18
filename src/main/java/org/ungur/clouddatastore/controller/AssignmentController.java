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
import org.ungur.clouddatastore.model.Assignment;
import org.ungur.clouddatastore.model.Message;
import org.ungur.clouddatastore.service.AssignmentService;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
	public ResponseEntity<Message> addAssignment(@Valid @RequestBody Assignment assignment) {

		assignmentService.createAssignment(assignment);// so postMan

		return ResponseEntity.ok().body(new Message("Created"));
	}

	@RequestMapping(value = "/getAssignment/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Assignment getAssignment(@PathVariable("id") Long id) {
		Assignment assignmentExample = assignmentService.readAssignment(id);

		return assignmentExample;
	}

	@RequestMapping(value = "/getAssignments", method = RequestMethod.GET)
	@ResponseBody // so postMan
	public ArrayList<Assignment> getAssignments() {
		ArrayList<Assignment> assignments = (ArrayList<Assignment>) assignmentService.readAllAssignments();

		return assignments;

	}

	@RequestMapping(value = "/updateAssignment", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateAssignment(@Valid @RequestBody Assignment assignment) {
		assignmentService.updateAssignment(assignment);// so postMan

		return ResponseEntity.ok().body(new Message("Updated"));
	}

}

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
import org.ungur.clouddatastore.model.Assignment;
import org.ungur.clouddatastore.model.Message;
import org.ungur.clouddatastore.service.AssignmentService;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;

	@RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
	public ResponseEntity<Message> addAssignment(@Valid @RequestBody Assignment assignment) {

		assignmentService.createAssignment(assignment);

		return ResponseEntity.ok().body(new Message("Created"));
	}

	@RequestMapping(value = "/addNyAssignment", method = RequestMethod.GET)
	public String addAssignment(Model model) {
		model.addAttribute("assignmentForm", new Assignment());

		return "addNyAssignment";
	}

	@RequestMapping(value = "/addNyAssignment", method = RequestMethod.POST)
	public String addAssignment(@ModelAttribute("assignmentForm") Assignment assignmentForm,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "addNyAssignment";
		}

		assignmentService.createAssignment(assignmentForm);
		return "redirect:/welcome";
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

	@RequestMapping(value = "/viewAllAssignments", method = RequestMethod.GET)
	public ArrayList<Assignment> viewAllAssignments(Model model) {
		ArrayList<Assignment> assignments = (ArrayList<Assignment>) assignmentService.readAllAssignments();
		model.addAttribute("list", assignments);

		return assignments;
	}

	@RequestMapping(value = "/updateAssignment", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateAssignment(@Valid @RequestBody Assignment assignment) {
		assignmentService.updateAssignment(assignment);// so postMan

		return ResponseEntity.ok().body(new Message("Updated"));
	}

	@RequestMapping(value = "/updateAnAssignment/{assignmentId}", method = RequestMethod.GET)
	public String updateAnAssignment(@PathVariable Long assignmentId, Model model) {
		model.addAttribute("updateForm", assignmentService.readAssignment(assignmentId));

		return "updateAnAssignment";
	}

	@RequestMapping(value = "/updateAnAssignment/{assignmentId}", method = RequestMethod.POST)
	public String updateAnAssignment(@ModelAttribute("updateForm") Assignment updateForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "updateAnAssignment";
		}
		assignmentService.updateAssignment(updateForm);

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/deleteAssigment/{assignmentId}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Message> deleteAssigment(@PathVariable("assignmentId") Long assignmentId) {
		assignmentService.deleteAssignment(assignmentId);

		return ResponseEntity.ok().body(new Message("Successfully deleted"));
	}

	@RequestMapping(value = "/deleteOneAssignment/{assignmentId}", method = RequestMethod.GET)
	public String deleteOneAssignment(@PathVariable Long assignmentId, Model model) {
		model.addAttribute("deleteAssignment", assignmentService.readAssignment(assignmentId));

		return "deleteOneAssignment";
	}

	@RequestMapping(value = "/deleteOneAssignment/{assignmentId}", method = RequestMethod.POST)
	public String deleteOneAssignment(@PathVariable Long assignmentId) {

		assignmentService.deleteAssignment(assignmentId);

		return "redirect:/welcome";
	}

}

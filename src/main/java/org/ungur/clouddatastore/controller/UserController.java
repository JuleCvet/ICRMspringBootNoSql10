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
import org.ungur.clouddatastore.model.Role;
import org.ungur.clouddatastore.model.User;
import org.ungur.clouddatastore.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ArrayList<User> getUsers(Model model) {
		ArrayList<User> users = (ArrayList<User>) userService.readAllUsers();
		model.addAttribute("list", users);

		return users;
	}

	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	@ResponseBody // so postMan
	public ArrayList<User> getAllUsers() {
		ArrayList<User> users = (ArrayList<User>) userService.readAllUsers();

		return users;

	}

	@RequestMapping(value = "/getuser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUser(@PathVariable("id") Long id) {
		User userExample = userService.readUser(id);

		return userExample;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.createUser(userForm);
		// securityService.autologin(userForm.getFullName(), userForm.get);
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/updateuser/{userID}", method = RequestMethod.GET)
	public String updateuser(@PathVariable Long userID, Model model) {
		model.addAttribute("updateForm", userService.readUser(userID));

		return "updateuser";
	}

	@RequestMapping(value = "/updateuser/{userID}", method = RequestMethod.POST)
	public String updateuserById(@PathVariable Long userID, @ModelAttribute("updateForm") User updateForm,
			BindingResult bindingResult, Model model) {

		User currUser = userService.readUser(userID);

		updateForm.setId(userID);
		updateForm.setIsDeleted(currUser.getIsDeleted());
		updateForm.setPassword(currUser.getPassword());
		userService.updateUser(updateForm);

		return "redirect:/users";
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateUser(@Valid @RequestBody User user) {
		userService.updateUser(user);// so postMan

		return ResponseEntity.ok().body(new Message("Updated"));
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {

		return "welcome";
	}

	@RequestMapping(value = "/users/batch", method = RequestMethod.POST)
	public ResponseEntity<Message> addUsers(@Valid @RequestBody Role users) {
		userService.createUser(users);

		return ResponseEntity.ok().body(new Message("Batch created: " + users.getUsers().size()));
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUser(Model model, String error, String logout) {
		if (error != null) {
			model.addAttribute("error", "Your username and password is invalid.");
		}

		if (logout != null) {
			model.addAttribute("message", "You have been logout successfully.");
		}
		model.addAttribute("login", new User());
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute User login) {

		return "welcome";
	}

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public String
	 * login(@RequestParam("username") String username, @RequestParam("password")
	 * String password) {
	 * 
	 * if (username == "ivan") return "welcome"; else { return "login"; } }
	 * 
	 */
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<Message> deleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);

		return ResponseEntity.ok().body(new Message("Successfully deleted"));
	}

	@RequestMapping(value = "/updateDeleteuser/{userID}", method = RequestMethod.GET)
	public String deleteUserByID(@PathVariable Long userID, Model model) {
		model.addAttribute("updateDeleteForm", userService.readUser(userID));

		return "updateDeleteuser";
	}

	/*
	 * @RequestMapping(value = "/delete/{userID}", method = RequestMethod.POST)
	 * public String deleteEmployeeById(@PathVariable Long userID) {
	 * 
	 * userService.deleteUser(userID);
	 * 
	 * return "redirect:/users"; }
	 */

	@RequestMapping(value = "/updateDeleteuser/{userID}", method = RequestMethod.POST)
	public String updateDeleteuser(@PathVariable Long userID, @ModelAttribute("updateDeleteForm") User updateDeleteForm,
			BindingResult bindingResult, Model model) {

		User currUser = userService.readUser(userID);

		updateDeleteForm.setId(userID);
		updateDeleteForm.setIsDeleted(true);
		updateDeleteForm.setPassword(currUser.getPassword());
		updateDeleteForm.setEmail(currUser.getEmail());
		updateDeleteForm.setFullName(currUser.getFullName());

		userService.updateUser(updateDeleteForm);

		return "redirect:/users";
	}

}

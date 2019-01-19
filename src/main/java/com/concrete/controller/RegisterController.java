package com.concrete.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concrete.model.Response;
import com.concrete.model.User;
import com.concrete.model.UserTO;
import com.concrete.service.UserService;

@RestController
@RequestMapping(value = "/register")
@CrossOrigin(origins = "*")
public class RegisterController {

	@Autowired
	private UserService userService;

	@PostMapping	
	public ResponseEntity<Response<User>> registerUser(@RequestBody UserTO userto, BindingResult result) {
		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		User userCreated = userService.register(userto);
		response.setResponse(userCreated);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}

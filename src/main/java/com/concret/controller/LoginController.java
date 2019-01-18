package com.concret.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concret.model.LoginTO;
import com.concret.model.Response;
import com.concret.model.User;
import com.concret.service.UserService;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	public ResponseEntity<Response<User>> login(@Valid @RequestBody LoginTO loginTO, BindingResult result){
		Response<User> response = new Response<User>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		User user = userService.login(loginTO);
		response.setResponse(user);
		return ResponseEntity.ok(response);
	}
}

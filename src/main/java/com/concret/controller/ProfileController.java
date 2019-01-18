package com.concret.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.concret.exception.NotAuthorizedException;
import com.concret.model.Response;
import com.concret.model.User;
import com.concret.service.UserService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class ProfileController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<User>> userProfile(@PathVariable("id") int id, HttpServletRequest request){
		Response<User> response = new Response<User>();
		
		String token = request.getHeader("Authorization");
		
		if(token == null) {
			throw new NotAuthorizedException();
		}
		
		User user = userService.returnUser(id, token);
		
		response.setResponse(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}

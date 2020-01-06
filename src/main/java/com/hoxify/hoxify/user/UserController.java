package com.hoxify.hoxify.user;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoxify.hoxify.shared.GenericResponse;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/api/1.0/users")
	GenericResponse createUser(@Valid @RequestBody User user) {
		userService.save(user);
		return new GenericResponse("User saved");
	}
}

package com.hoxify.hoxify.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoxify.hoxify.shared.CurrentUser;
import com.hoxify.hoxify.user.vm.UserVM;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	UserVM handleLogin(@CurrentUser User loggedInUser) {
		return new UserVM(loggedInUser);
	}
		
}

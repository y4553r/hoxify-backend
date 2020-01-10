package com.hoxify.hoxify.user;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hoxify.hoxify.shared.CurrentUser;

@RestController
public class LoginController {
	
	@PostMapping("/api/1.0/login")
	Map<String, Object> handleLogin(@CurrentUser User loggedInUser) {
		return Collections.singletonMap("id", loggedInUser.getId());
	}
		
}

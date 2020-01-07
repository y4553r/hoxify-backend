package com.hoxify.hoxify.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	UserRepository userRepository;

	BCryptPasswordEncoder passwordEncoder;
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}
	
	public User save(User user) {
		User inDB = userRepository.findByUsername(user.getUsername());
		if(inDB != null)
			throw new DuplicateUsernameException();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
}

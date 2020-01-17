package com.hoxify.hoxify.user.vm;

import com.hoxify.hoxify.user.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVM {
	
	private long id;
	
	private String username;
	
	private String displayName;
	
	private String image;

	public UserVM(User user) {
		this.setId(user.getId());
		this.setDisplayName(user.getDisplayName());
		this.setUsername(user.getUsername());
		this.setImage(user.getImage());
	}
	
}

package com.sonndc.dto;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.sonndc.entity.User;

public class AuthUserDto extends org.springframework.security.core.userdetails.User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private User user;
	
	public AuthUserDto(User user) {
		super(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
	}
}

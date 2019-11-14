package com.sonndc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class UserDto {
	private long id;
	private String username;
	private String password;
	private String phone;
	private String role;
	
	public UserDto() {
		super();
	}

	public UserDto(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username.trim();
        this.password = password.trim();
    }
}

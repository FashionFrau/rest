package com.fashionfrau.security.transfer;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by tenaz3 on 20.05.17.
 */

//Simple placeholder for info extracted from the JWT

public class JwtUserDto {

	private String id;

	private String username;

	private String role;

	private String accessToken;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}

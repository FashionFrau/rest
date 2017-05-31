package com.fashionfrau.security.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/*
  Created by tenaz3 on 20.05.17.
 */

/**
 * Holder for JWT token from the request.
 * Other fields aren't used but necessary to comply to the contracts of AbstractUserDetailsAuthenticationProvider
 */
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private final String jwtAccessToken;

	public JwtAuthenticationToken(String jwtAccessToken) {
		super(null, null);
		this.jwtAccessToken = jwtAccessToken;
	}

	public String getJwtAccessToken() {
		return jwtAccessToken;
	}

	@Override public Object getCredentials() {
		return null;
	}

	@Override public Object getPrincipal() {
		return null;
	}
}

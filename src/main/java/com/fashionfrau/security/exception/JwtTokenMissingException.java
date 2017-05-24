package com.fashionfrau.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by tenaz3 on 20.05.17.
 */
public class JwtTokenMissingException extends AuthenticationException {
	public JwtTokenMissingException(String message) {
		super(message);
	}
}

package com.fashionfrau.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by tenaz3 on 20.05.17.
 */
public class JwtTokenMissingException extends AuthenticationException {

	private static final long serialVersionUID = -5730377954692718541L;

	public JwtTokenMissingException(String message) {
		super(message);
	}
}

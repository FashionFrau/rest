package com.fashionfrau.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by tenaz3 on 20.05.17.
 */
public class JwtTokenMalformedException extends AuthenticationException {

	private static final long serialVersionUID = -1422664022036790843L;

	public JwtTokenMalformedException(String message) {
		super(message);
	}
}

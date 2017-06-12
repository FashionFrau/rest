package com.fashionfrau.api.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tenaz3 on 20.05.17.
 */

// Defines where to go after successful login. In this implementation just make sure nothing is done (REST API constains no pages)
public class JwtAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Override public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

	}
}

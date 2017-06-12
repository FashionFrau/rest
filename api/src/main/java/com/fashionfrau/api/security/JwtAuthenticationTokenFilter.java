package com.fashionfrau.api.security;

import com.fashionfrau.api.exception.JwtTokenMissingException;
import com.fashionfrau.api.model.JwtAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tenaz3 on 20.05.17.
 */

// Filter that orchestrates authentication by using supplied JWT token
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

	@Autowired JwtConfig jwtConfig;

	public JwtAuthenticationTokenFilter() {
		super("/api/**");
	}

	@Override protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		if (request.getPathInfo().matches("/auth/callback")) {
			return false;
		}
		return super.requiresAuthentication(request, response);
	}

	@Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String header = request.getHeader(jwtConfig.getHeader());

		if (header == null || !header.startsWith("Bearer ")) {
			throw new JwtTokenMissingException("No JWT token found in request headers");
		}

		String authToken = header.substring(7);

		JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

		return getAuthenticationManager().authenticate(authRequest);
	}

	@Override protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain, Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);

		// As this authentication is in HTTP header, after success we need to continue the request normally
		// and return the response as if the resource was not secured at all
		chain.doFilter(request, response);
	}

}

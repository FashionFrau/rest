package com.fashionfrau.api.security;

import com.fashionfrau.api.exception.JwtTokenMalformedException;
import com.fashionfrau.api.model.AuthenticatedUser;
import com.fashionfrau.api.model.JwtAuthenticationToken;
import com.fashionfrau.api.security.until.JwtTokenValidator;
import com.fashionfrau.api.transfer.JwtUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tenaz3 on 20.05.17.
 */

// Used for checking the token from the request and supply the UserDetails if the token is valid

@Component public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired private JwtTokenValidator jwtTokenValidator;

	@Override protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

	}

	@Override protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;

		String jwtAccessToken = jwtAuthenticationToken.getJwtAccessToken();

		final JwtUserDto jwtUserDto = jwtTokenValidator.parseToken(jwtAccessToken);

		if (jwtUserDto == null) {
			throw new JwtTokenMalformedException("JWT token is not valid");
		}

		List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtUserDto.getRole());

		return new AuthenticatedUser(jwtUserDto.getId(), jwtUserDto.getUsername(), jwtAccessToken, authorityList);
	}

	@Override public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}
}

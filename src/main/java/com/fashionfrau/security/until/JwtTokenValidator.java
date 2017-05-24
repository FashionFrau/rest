package com.fashionfrau.security.until;

import com.fashionfrau.controller.AuthInstagramController;
import com.fashionfrau.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by tenaz3 on 20.05.17.
 */
// Class validates a given token by using the secret configured in the application
@Component public class JwtTokenValidator {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenValidator.class);

	@Value("${jwt.secret}") private String secret;

	/**
	 * Tries to parse specified String as a JWT token. If successful, returns User object with username, id and role prefilled (extracted from token).
	 * If unsuccessful (token is invalid or not containing all required user properties), simply returns null.
	 *
	 * @param token the JWT token to parse
	 * @return the User object extracted from specified token or null if a token is invalid.
	 */
	public JwtUserDto parseToken(String token) {
		JwtUserDto user = null;

		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			user = new JwtUserDto();
			user.setUsername(body.getSubject());
			user.setId((String) body.get("userId"));
			user.setRole((String) body.get("role"));

		} catch (JwtException e) {
			logger.warn("Fail to recover user from JWT", e);
		}
		return user;
	}
}

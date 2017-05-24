package com.fashionfrau.security.until;

import com.fashionfrau.security.config.JwtConfig;
import com.fashionfrau.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by tenaz3 on 20.05.17.
 */

//  Convenience class to generate a token for testing your requests.
//  Make sure the used secret here matches the on in your application.yml
public class JwtTokenGenerator {

	/**
	 * Generates a JWT token containing username as subject, and userId and role as additional claims. These properties are taken from the specified
	 * User object. Tokens validity is infinite.
	 */
	public static String generateToken(JwtUserDto user, String secret) {

		Claims claims = Jwts.claims().setSubject(user.getUsername());
		claims.put("userId", user.getId() + "");
		claims.put("role", user.getRole());

		return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}

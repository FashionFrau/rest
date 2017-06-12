package com.fashionfrau.api.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by tenaz3 on 20.05.17.
 */
@Component @EnableConfigurationProperties @ConfigurationProperties(prefix = "jwt") public class JwtConfig {

	@Value("${jwt.header}") private String header;

	@Value("${jwt.secret}") private String secret;

	public String getHeader() {
		return header;
	}

	public String getSecret() {
		return secret;
	}
}

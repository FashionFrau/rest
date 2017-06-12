package com.fashionfrau.instagram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by tenaz3 on 12.06.17.
 */
@Component @EnableConfigurationProperties @ConfigurationProperties(prefix = "instagram") public class InstagramConfig {

	@Value("${instagram.clientId}") private String clientId;

	@Value("${instagram.clientSecret}") private String clientSecret;

	@Value("${instagram.callbackUrl}") private String callbackUrl;

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}
}

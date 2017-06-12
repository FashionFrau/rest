package com.fashionfrau.instagram.service;

import com.fashionfrau.instagram.config.InstagramConfig;
import org.jinstagram.InstagramClient;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.exceptions.InstagramException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by tenaz3 on 12.06.17.
 */
@Service public class InstaService {

	@Autowired InstagramConfig instagramConfig;

	InstagramService instagramService;

	public InstaService() {
	}

	@PostConstruct public void setUp() {
		this.instagramService = new InstagramAuthService().apiKey(instagramConfig.getClientId())
				.apiSecret(instagramConfig.getClientSecret()).callback(instagramConfig.getCallbackUrl()).build();
	}

	public UserInfo authenticate(String code) throws InstagramException {

		Verifier verifier = new Verifier(code);

		final Token token = instagramService.getAccessToken(verifier);

		InstagramClient instagram = instagramService.getInstagram(token);

		return instagram.getCurrentUserInfo();
	}
}

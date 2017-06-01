//package com.fashionfrau.controller;
//
//import com.fashionfrau.security.config.JwtConfig;
//import com.fashionfrau.security.transfer.JwtUserDto;
//import com.fashionfrau.security.until.JwtTokenGenerator;
//import org.jinstagram.InstagramClient;
//import org.jinstagram.auth.InstagramAuthService;
//import org.jinstagram.auth.model.Token;
//import org.jinstagram.auth.model.Verifier;
//import org.jinstagram.auth.oauth.InstagramService;
//import org.jinstagram.entity.users.basicinfo.UserInfo;
//import org.jinstagram.exceptions.InstagramException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
//import javax.ws.rs.core.Response;
//
///**
// * Created by tenaz3 on 19.05.17.
// */
//@Component @Path("/auth") public class AuthInstagramController {
//
//	private static final Logger logger = LoggerFactory.getLogger(AuthInstagramController.class);
//
//	@Autowired JwtConfig jwtConfig;
//
//	InstagramService instagramService;
//
//	private String clientId = "b0a5c417a94a43df83943434131f820b";
//	private String clientSecret = "5e79af6674464478a3cdd308fbb1b87a";
//	private String callbackUrl = "http://localhost:8080/api/auth/callback";
//
//	@GET @Produces("application/json") @Path("/callback") public Response callback(@QueryParam("code") String code)
//			throws InstagramException {
//
//		instagramService = new InstagramAuthService().apiKey(clientId).apiSecret(clientSecret).callback(callbackUrl)
//				.build();
//
//		Verifier verifier = new Verifier(code);
//		final Token token = instagramService.getAccessToken(verifier);
//
//		InstagramClient instagram = instagramService.getInstagram(token);
//
//		UserInfo info = instagram.getCurrentUserInfo();
//
//		JwtUserDto user = new JwtUserDto();
//		user.setId(info.getData().getId());
//		user.setUsername(info.getData().getUsername());
//		user.setRole("user");
//
//		final String accessToken = JwtTokenGenerator.generateToken(user, jwtConfig.getSecret());
//
//		user.setAccessToken(accessToken);
//
//		return Response.ok(user).build();
//	}
//}

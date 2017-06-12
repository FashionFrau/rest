package com.fashionfrau.instagram.controller;

import com.fashionfrau.instagram.dto.CurrentUser;
import com.fashionfrau.instagram.service.InstaService;
import com.fashionfrau.security.service.JwtUserService;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.exceptions.InstagramException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by tenaz3 on 19.05.17.
 */
@Component @Path("/auth") public class AuthInstagramController {

	private static final Logger logger = LoggerFactory.getLogger(AuthInstagramController.class);

	@Autowired InstaService instaService;

	@Autowired JwtUserService jwtUserService;

	@GET @Produces("application/json") @Path("/callback") public Response callback(@QueryParam("code") String code)
			throws InstagramException {

		final UserInfo userInfo = instaService.authenticate(code);

		final CurrentUser currentUser = jwtUserService.createCurrentUser(userInfo);

		return Response.ok(currentUser).build();
	}
}

package com.fashionfrau.security.service;

import com.fashionfrau.instagram.dto.CurrentUser;
import com.fashionfrau.security.config.JwtConfig;
import com.fashionfrau.security.until.JwtTokenGenerator;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.entity.users.basicinfo.UserInfoData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tenaz3 on 12.06.17.
 */
@Service public class JwtUserService {

	@Autowired JwtConfig jwtConfig;

	public CurrentUser createCurrentUser(UserInfo userInfo) {

		final UserInfoData userInfoData = userInfo.getData();

		final String accessToken = JwtTokenGenerator
				.generateToken(userInfoData.getId(), userInfoData.getUsername(), "user", jwtConfig.getSecret());

		CurrentUser user = new CurrentUser.Builder(userInfoData, accessToken).build();

		return user;
	}
}

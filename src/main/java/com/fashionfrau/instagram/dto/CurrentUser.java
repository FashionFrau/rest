package com.fashionfrau.instagram.dto;

import org.jinstagram.entity.users.basicinfo.UserInfoData;

/**
 * Created by tenaz3 on 12.06.17.
 */
public class CurrentUser {

	private UserInfoData userInfoData;

	private String accessToken;

	private CurrentUser(UserInfoData userInfoData, String accessToken) {
		this.userInfoData = userInfoData;
		this.accessToken = accessToken;
	}

	public UserInfoData getUserInfoData() {
		return userInfoData;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public static class Builder {
		private UserInfoData userInfoData;

		private String accessToken;

		public Builder(UserInfoData userInfoData, String accessToken) {
			this.userInfoData = userInfoData;
			this.accessToken = accessToken;
		}

		public Builder userInfoData(UserInfoData userInfoData) {
			this.userInfoData = userInfoData;
			return this;
		}

		public Builder accessToken(String accessToken) {
			this.accessToken = accessToken;
			return this;
		}

		public CurrentUser build() {
			return new CurrentUser(userInfoData, accessToken);
		}
	}
}

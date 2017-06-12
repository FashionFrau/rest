package com.fashionfrau.api.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by tenaz3 on 20.05.17.
 */

// Holds the info for a authenticated user (Principal)
public class AuthenticatedUser implements UserDetails {
	private final String id;
	private final String username;
	private final String accessToken;
	private final Collection<? extends GrantedAuthority> authorityList;

	public AuthenticatedUser(String id, String username, String accessToken, List<GrantedAuthority> authorityList) {
		this.id = id;
		this.username = username;
		this.accessToken = accessToken;
		this.authorityList = authorityList;
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorityList;
	}

	@Override public String getPassword() {
		return null;
	}

	@Override public String getUsername() {
		return username;
	}

	@Override public boolean isAccountNonExpired() {
		return false;
	}

	@Override public boolean isAccountNonLocked() {
		return false;
	}

	@Override public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override public boolean isEnabled() {
		return true;
	}

	public String getAccessToken() {
		return accessToken;
	}
}

package com.fashionfrau.security.config;

import com.fashionfrau.security.JwtAuthenticationEntryPoint;
import com.fashionfrau.security.JwtAuthenticationProvider;
import com.fashionfrau.security.JwtAuthenticationSuccessHandler;
import com.fashionfrau.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

/**
 * Created by tenaz3 on 20.05.17.
 */
@Configuration @EnableWebSecurity @EnableAutoConfiguration @EnableGlobalMethodSecurity(prePostEnabled = true) public class WebSecurityConfig
		extends WebSecurityConfigurerAdapter {

	@Autowired private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired private JwtAuthenticationProvider authenticationProvider;

	@Override public AuthenticationManager authenticationManagerBean() throws Exception {
		return new ProviderManager(Arrays.asList(authenticationProvider));
	}

	@Override protected void configure(HttpSecurity http) throws Exception {
		http
				// we don't need CSRF because our token is invulnerable
				.csrf().disable().authorizeRequests().antMatchers("/api/auth/callback").permitAll().anyRequest()
				.authenticated().and()
				// Call our errorHandler if authentication/authorisation fails
				.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				// don't create session
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //.and()

		// Custom JWT based security filter
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		// disable page caching
		http.headers().cacheControl();
	}

	@Bean public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		JwtAuthenticationTokenFilter authenticationTokenFilter = new JwtAuthenticationTokenFilter();

		authenticationTokenFilter.setAuthenticationManager(authenticationManager());
		authenticationTokenFilter.setAuthenticationSuccessHandler(new JwtAuthenticationSuccessHandler());

		return authenticationTokenFilter;
	}
}

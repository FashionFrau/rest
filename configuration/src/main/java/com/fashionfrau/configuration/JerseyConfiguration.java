package com.fashionfrau.configuration;

import com.fashionfrau.api.controller.Test;
import com.fashionfrau.api.exception.GenericExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

//import com.fashionfrau.controller.AuthInstagramController;

/**
 * Created by tenaz3 on 19.05.17.
 */
@Configuration @ApplicationPath("/api") public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
	}

	@PostConstruct public void setUp() {
		//		register(AuthInstagramController.class);
		register(GenericExceptionMapper.class);
		register(Test.class);
	}

}

package com.fashionfrau.configuration;

import com.fashionfrau.controller.Test;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

/**
 * Created by tenaz3 on 19.05.17.
 */
@ComponentScan("com.fashionfrau.controller")
@Configuration @ApplicationPath("/api") public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
	}

	@PostConstruct public void setUp() {
		register(Test.class);
	}

}

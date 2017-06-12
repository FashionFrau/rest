package com.fashionfrau.api.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by tenaz3 on 22.05.17.
 */
@Path("/test") @Component public class Test {
	@GET @Produces("application/json") public Response test() {
		return Response.ok("AA").build();
	}
}

package com.fashionfrau.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by tenaz3 on 22.05.17.
 */
@Component public class Test {
	@GET @Path("/test") @Produces("application/json") public Response test() {
		return Response.ok("AA").build();
	}
}

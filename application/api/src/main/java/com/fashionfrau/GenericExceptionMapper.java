package com.fashionfrau;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by tenaz3 on 19.05.17.
 */

@Provider public class GenericExceptionMapper implements ExceptionMapper<Throwable> {
	@Override public Response toResponse(Throwable exception) {
		return Response.serverError().entity(exception.getMessage()).build();
	}
}

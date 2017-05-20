package controller;

import org.jinstagram.InstagramClient;
import org.jinstagram.auth.InstagramAuthService;
import org.jinstagram.auth.model.Token;
import org.jinstagram.auth.model.Verifier;
import org.jinstagram.auth.oauth.InstagramService;
import org.jinstagram.entity.users.basicinfo.UserInfo;
import org.jinstagram.exceptions.InstagramException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by tenaz3 on 19.05.17.
 */
@Component @Path("/auth") public class AuthInstagramController {

	private static final Logger logger = LoggerFactory.getLogger(AuthInstagramController.class);

	InstagramService instagramService;

	private String clientId = "b0a5c417a94a43df83943434131f820b";
	private String clientSecret = "5e79af6674464478a3cdd308fbb1b87a";
	private String callbackUrl = "http://localhost:8080/rest/auth/callback";

	@GET @Produces("application/json") @Path("/callback") public Response callback(@QueryParam("code") String code)
			throws InstagramException {

		instagramService = new InstagramAuthService().apiKey(clientId).apiSecret(clientSecret).callback(callbackUrl)
				.build();

		Verifier verifier = new Verifier(code);
		final Token token = instagramService.getAccessToken(verifier);

		InstagramClient instagram = instagramService.getInstagram(token);

		UserInfo info = instagram.getCurrentUserInfo();
		logger.info(info.toString());

		return Response.ok(info).build();
	}
}

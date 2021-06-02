package fr.ibformation.scenarryo_back.security.jwt;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class AuthEntryPointJwt implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(AuthEntryPointJwt.class);

	/**
	 * function commence :
	 * This method will be triggerd anytime unauthenticated User requests a secured HTTP resource
	 * @param request
	 * @param response
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		logger.error("erreur non-autorisée : {}", authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "erreur: non-autorisé");
	}

}
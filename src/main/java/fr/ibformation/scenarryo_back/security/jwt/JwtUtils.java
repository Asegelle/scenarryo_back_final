package fr.ibformation.scenarryo_back.security.jwt;


import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import fr.ibformation.scenarryo_back.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;

// provides methods for generating, parsing, validating JWT
@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${scenarryo.app.jwtSecret}")
	private String jwtSecret;

	@Value("${scenarryo.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	/**
	 * function generateJwtToken :
	 * generate specific access token for the user connected
	 * @param authentication
	 * @return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	 */
	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	
	/**
	 * function getUserNameFromJwtToken :
	 * @param token
	 * @return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	 */
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	
	/**
	 * function validateJwtToken :
	 * @param authToken
	 * @return false
	 */
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("signature JWT invalide: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("token JWT invalide: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("le token JWT est expiré: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("le token JWT n'est pas pris en charge: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string est vide: {}", e.getMessage());
		}

		return false;
	}
}
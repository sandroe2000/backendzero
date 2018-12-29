package br.com.sdvs.cdr.security;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	static Logger logger = LoggerFactory.getLogger(TokenAuthenticationService.class);

	// EXPIRATION_TIME = 10 horas
	static final long EXPIRATION_TIME = 36000000;
	static final String SECRET = "kwhhfwdfhwdg85876jhjv6gv6f6vGR5t5Fef54vhjJH097g2yvt";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
			
	static void addAuthentication(HttpServletResponse response, String username) {
		String JWT = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	}
	
	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		try {
			if (token != null) {
				// faz parse do token
				String user = Jwts.parser()
						.setSigningKey(SECRET)
						.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
						.getBody()
						.getSubject();
				
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
				}
			}
		}catch (ExpiredJwtException  e) {
			//TODO PUT LOG HERE
			logger.error("TOKEN EXPIRADO, EXIGIDO NOVO LOGON. "+e.getMessage());
		}
		return null;
	}
}

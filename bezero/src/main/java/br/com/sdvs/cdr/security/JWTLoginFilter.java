package br.com.sdvs.cdr.security;

import br.com.sdvs.cdr.model.User;
import br.com.sdvs.cdr.model.dto.DtoUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	protected JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		User users = new ObjectMapper().readValue(request.getInputStream(), User.class);

		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),
				users.getPassword(), Collections.emptyList()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResults) throws IOException, ServletException {
		 
		final ObjectMapper mapper = new ObjectMapper();
		DtoUser dtoUser = (DtoUser) authResults.getPrincipal();
		User user = dtoUser.getUser();

		HttpServletResponse resp = (HttpServletResponse)response;
		resp.addHeader("Grants", mapper.writeValueAsString(user.getAccess()));

		TokenAuthenticationService.addAuthentication(response, authResults.getName());
	}

}

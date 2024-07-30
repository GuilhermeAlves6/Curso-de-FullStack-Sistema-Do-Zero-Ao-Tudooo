package br.com.guilherme.projeto.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.guilherme.projeto.service.UserDetailServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthFilterToken extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = getToken(request);
			
		}catch(Exception e) {
			
		}finally {
			
		}
		
	}
	
	private  String getToken(HttpServletResponse request) {
		String headerToken =  request.getHeader("Authorization");
		if(StringUtils.hasText(headerToken) && headerToken.startsWith("Bearer")) {
			return headerToken.replace("Bearer ", "");
		}
		return null;
	}

}

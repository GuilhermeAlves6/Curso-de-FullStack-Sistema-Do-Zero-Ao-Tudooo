package br.com.guilherme.projeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.guilherme.projeto.dto.AcessDTO;
import br.com.guilherme.projeto.dto.AuthenticationDTO;
import br.com.guilherme.projeto.security.jwt.JwtUtils;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	public AcessDTO login(AuthenticationDTO AuthDto) {

		try {
			// Cria mecanismo de credencial para o spring
			UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(
					AuthDto.getUsername(), AuthDto.getPassword());

			// Prepara mecanismo para autenticacao
			Authentication authentication = authenticationManager.authenticate(userAuth);

			// Busca usuario logado
			UserDetailsImpl userAutenticate = (UserDetailsImpl) authentication.getPrincipal();
			
			
			String token = jwtUtils.generateTokenFromUserDetailsImpl(userAutenticate);
			
			AcessDTO acessDto = new AcessDTO(token);

		} catch (BadCredentialsException e) {
			// TODO LOGIN OU SENHA INVALIDO
		}
		return null;
	}

}

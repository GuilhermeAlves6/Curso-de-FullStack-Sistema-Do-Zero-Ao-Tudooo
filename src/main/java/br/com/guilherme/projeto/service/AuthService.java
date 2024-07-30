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

	public AcessDTO login(AuthenticationDTO authDto) {

		try {
			// Cria mecanismo de credencial para o spring
			UsernamePasswordAuthenticationToken userAuthenticationToken = new UsernamePasswordAuthenticationToken(
					authDto.getUsername(), authDto.getPassword());

			// Prepara mecanismo para autenticacao
			Authentication authentication = authenticationManager.authenticate(userAuthenticationToken);

			// Busca usuario logado
			UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();
			
			
			String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);
			
			AcessDTO accessDto = new AcessDTO(token);
			
			return accessDto;
			
		} catch (BadCredentialsException e) {
			// TODO LOGIN OU SENHA INVALIDO
		}
		return new AcessDTO("Acesso negado");
	}

}

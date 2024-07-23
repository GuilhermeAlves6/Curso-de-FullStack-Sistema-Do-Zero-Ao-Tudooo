package br.com.guilherme.projeto.security.jwt;

import java.nio.charset.MalformedInputException;
import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.guilherme.projeto.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {

	@Value("${projeto.jwtSecret}")
	private String jwtSecret;

	@Value("${projeto.jwtExpirationsMs}")
	private int jwtExpirationMs;

	public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDetail) {
		return Jwts.builder().setSubject(userDetail.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
				.signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
	}

	public Key getSigninKey() {
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
		return key;
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
			return true;

		} catch (MalformedJwtException e) {
			System.out.println("Token inválido" + e.getMessage());
		} catch (ExpiredJwtException e) {
			System.out.println("Token inválido" + e.getMessage());
		} catch (UnsupportedJwtException e) {
			System.out.println("Token inválido" + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Token Argumento inválido" + e.getMessage());
		}
		return false;

	}
}

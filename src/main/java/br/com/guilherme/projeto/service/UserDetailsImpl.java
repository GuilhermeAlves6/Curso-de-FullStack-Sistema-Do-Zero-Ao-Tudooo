package br.com.guilherme.projeto.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.guilherme.projeto.entity.UsuarioEntity;

public class UserDetailsImpl implements UserDetails {
	
	private Long id;
	
	private String name;
	
	private String Username;
	
	private String email;
	
	private String password;
	
	
	
	public UserDetailsImpl(Long id, String name, String username, String email,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.name = name;
		Username = username;
		this.email = email;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(UsuarioEntity usuario) {
		
		return new UserDetailsImpl(
				usuario.getId(), 
				usuario.getNome(), 
				usuario.getLogin(), 
				usuario.getEmail(), 
				new ArrayList<>());
	}
	
	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return Username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}

}

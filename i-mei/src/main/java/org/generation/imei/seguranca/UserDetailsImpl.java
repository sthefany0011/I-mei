package org.generation.imei.seguranca;

import java.util.Collection;

import org.generation.imei.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L; //classe de controle interno
	
	private String userName;//atributos privados
	private String password;
	
	//construtor de classe. recebe user e popula com login e senha
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getEmail();
		this.password = user.getSenha();
	
	}
	//construtor vazio
	public UserDetailsImpl() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

package org.generation.imei.seguranca;

import java.util.Optional;

import org.generation.imei.model.Usuario;
import org.generation.imei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " Não encontrado."));

		//return (UserDetails) user.map(UserDetailsImpl::new).get();
		return user.map(UserDetailsImpl::new).get();
	}
}

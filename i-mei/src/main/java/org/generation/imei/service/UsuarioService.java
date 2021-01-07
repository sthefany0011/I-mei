package org.generation.imei.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.generation.imei.model.UserLogin;
import org.generation.imei.model.Usuario;
import org.generation.imei.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	// Regra de negocio para cadastrar o usuario (é uma classe não interface).

	@Autowired
	private UsuarioRepository repository;
	
	//Método que recebe um usuario e retorna o usuario (cadastrar usuario)
	public Usuario CadastrarUsuario(Usuario usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> usuarioexiste = repository.findByEmail(usuario.getEmail()); //codigo para manter email como unico cadastro
		
		if(usuarioexiste.isPresent()) {
			return null;
		}
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder); // Chama o usuario e modifica o atributo senha, passando a senha encriptada
		
		return repository.save(usuario); // Salva o objeto usuario com a senha modificada.
	}
	// Método logar da camada de segurança
	
	public Optional<UserLogin> Logar(Optional<UserLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByEmail(user.get().getEmail());
		
	if(usuario.isPresent()) { // Condição se o usuario tiver algo dentro, o metodo compara a senha encriptada com a senha digitada do usuario
		if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) { // vai verificar se a senhas foram digitadas iguais
		
		String auth = user.get().getEmail() + ":" + user.get().getSenha(); 
		byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodeAuth); // autenticacao header, prefixo basic concatenando com + new string (converte o array de byte pra string)
		
		user.get().setToken(authHeader); // preenche o token
		user.get().setNome(usuario.get().getNome()); // acesso ao token e coloca o que veio no username
		
		return user; // retorna o usuario
		
			}
		}
	 return null; // se nao entra nesse if ele retorna um nulo. o usuario nao existe no banco de dados.
	}
}

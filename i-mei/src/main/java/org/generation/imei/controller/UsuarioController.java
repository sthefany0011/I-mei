package org.generation.imei.controller;

import java.util.List;
import java.util.Optional;

import org.generation.imei.model.UserLogin;
import org.generation.imei.model.Usuario;
import org.generation.imei.repository.UsuarioRepository;
import org.generation.imei.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	private UsuarioService usuarioService;

	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAllUsuario() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findByIdUsuario(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> putUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}

	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/nome/{text}")
	public ResponseEntity<List<Usuario>> findByNome(@PathVariable String text) {
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(text));

	}
	//metodos para o security
	@PostMapping("/logar") // login do usuario, endpoint q nao passa pelo filtro de segurança
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar") // tmb passa pelo filtro, mas nao eh barrado.
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.CadastrarUsuario(usuario));
	}
}

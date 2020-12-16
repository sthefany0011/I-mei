package org.generation.imei.controller;

import org.generation.imei.repository.TemaRepository;
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
import org.generation.imei.model.Tema;
import java.util.List;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*")
@RequestMapping("/tema")
public class TemaController 
{
	@Autowired
	private TemaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> findAllTema()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tema> findById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}
	
	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}		
	
	@GetMapping("/{text}")
	public ResponseEntity<List<Tema>> findByDescricao(@PathVariable String text)
	{
		return ResponseEntity.ok(repository.findByDescricao(text));
				/*map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());*/
	}
}

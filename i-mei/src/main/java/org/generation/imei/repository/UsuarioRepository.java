package org.generation.imei.repository;

import java.util.List;
import java.util.Optional;


import org.generation.imei.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

	public Optional<Usuario> findByEmail(String email);

	@Query(value = "select * from db_i_mei.usuario where nome like :text%", nativeQuery=true)
	public List<Usuario> findByNome(@Param ("text")String text);
}

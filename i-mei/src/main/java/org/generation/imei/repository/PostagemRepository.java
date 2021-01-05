package org.generation.imei.repository;

import java.util.List;

import org.generation.imei.model.Postagem;
import org.generation.imei.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
<<<<<<< HEAD
=======
	
	@Query(value = "select * from db_i_mei.postagem where titulo like :text%", nativeQuery=true)
	public List<Postagem> findByTitulo(@Param ("text")String text);
>>>>>>> 83ea119335ab73ae5fc29e31f8dcce57a633c0b6

}

package org.generation.imei.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")

public class Postagem {

	// attributes
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
	@Size(max = 50)
	private String fk_email;
	@NotNull
	private long fk_tema;
	@NotNull
	@Size(max = 100)
	private String titulo;
	@NotNull
	@Size(max = 1000)
	private String campo;
	@NotNull
	@Size(max = 200)
	private String link_imagem;
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_post = new java.sql.Date(System.currentTimeMillis());

	// Relationship between tables (Tema 1 --- N Postagem)
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	// Relationship between tables (Postagem 1 --- N usuario)
	@OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("postagem")
	private List<Usuario> usuario;

	// getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFk_email() {
		return fk_email;
	}

	public void setFk_email(String fk_email) {
		this.fk_email = fk_email;
	}

	public long getFk_tema() {
		return fk_tema;
	}

	public void setFk_tema(long fk_tema) {
		this.fk_tema = fk_tema;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getLink_imagem() {
		return link_imagem;
	}

	public void setLink_imagem(String link_imagem) {
		this.link_imagem = link_imagem;
	}

	public Date getData_post() {
		return data_post;
	}

	public void setData_post(Date data_post) {
		this.data_post = data_post;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

}

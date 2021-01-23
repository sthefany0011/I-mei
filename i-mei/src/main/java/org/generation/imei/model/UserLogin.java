package org.generation.imei.model;

public class UserLogin {
	
	// Atributos
	private long id;
	private String nome;
	private String email;
	private String senha;
	private String token;
	private String pessoa;
	private String foto;
	private String tipo;
		
	//getters & setters
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;		
	}
	
	public String getNome() {
		return nome;
		}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	
	
}

package br.com.ufc.gedito.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = -8111987822482467186L;
	
	private String nome;
	private String senha;
	
	public Usuario() {
		
	}

	public Usuario(String nome, String senha) {
		super();
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

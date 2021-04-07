package br.com.ufc.gedito.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = -7797235450568643584L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "semestre_id")
	private Semestre semestre;

	@JsonIgnore
	@OneToMany(mappedBy = "disciplina")
	private List<PreRequisito> preRequisitos;
	
	@ManyToMany(mappedBy = "disciplinas")
	private List<Topico> topicos;
	
	public Disciplina() {
		
	}

	public Disciplina(String nome, Semestre semestre, List<PreRequisito> preRequisitos, List<Topico> topicos) {
		super();
		this.nome = nome;
		this.semestre = semestre;
		this.preRequisitos = preRequisitos;
		this.topicos = topicos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public List<PreRequisito> getPreRequisitos() {
		return preRequisitos;
	}

	public void setPreRequisitos(List<PreRequisito> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

	public List<Topico> getTopicos() {
		return topicos;
	}

	public void setTopicos(List<Topico> topicos) {
		this.topicos = topicos;
	}

}

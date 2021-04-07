package br.com.ufc.gedito.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Semestre implements Serializable {
	private static final long serialVersionUID = 895916279832252222L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy = "semestre")
	private List<Disciplina> disciplinas;
	
	public Semestre() {
		
	}

	public Semestre(String nome, List<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.disciplinas = disciplinas;
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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}

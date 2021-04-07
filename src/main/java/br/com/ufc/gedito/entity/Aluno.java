package br.com.ufc.gedito.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Usuario {
	private static final long serialVersionUID = 4727540716887266983L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	private String curso;
	
	public Aluno() {
		
	}

	public Aluno(String curso, Integer matricula) {
		super();
		this.curso = curso;
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	
}

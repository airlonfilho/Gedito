package br.com.ufc.gedito.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Topico implements Serializable {
	private static final long serialVersionUID = 6143463038471787380L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	@JsonIgnore
	@OneToMany(mappedBy = "topico")
	private List<RelacionamentoTopico> relacionamento_topico;
	
	@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "DISCIPLINA_TOPICO",
            joinColumns = @JoinColumn(name = "disciplina_id"),
            inverseJoinColumns = @JoinColumn(name = "topico_id")
    )
	private List<Disciplina> disciplinas;
	
	public Topico() {
		
	}

	public Topico(String nome, String descricao, List<RelacionamentoTopico> relacionamento_topico, List<Disciplina> disciplinas) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.relacionamento_topico = relacionamento_topico;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<RelacionamentoTopico> getRelacionamento_topico() {
		return relacionamento_topico;
	}

	public void setRelacionamento_topico(List<RelacionamentoTopico> relacionamento_topico) {
		this.relacionamento_topico = relacionamento_topico;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}

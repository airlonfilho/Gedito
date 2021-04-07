package br.com.ufc.gedito.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RelacionamentoTopico implements Serializable {
	private static final long serialVersionUID = -1998144820972607445L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "topico_id")
	private Topico topico;
	
	public RelacionamentoTopico() {
		
	}

	public RelacionamentoTopico(Topico topico) {
		super();
		this.topico = topico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

}

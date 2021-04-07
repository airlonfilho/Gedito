package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.RelacionamentoTopico;

public interface RelacionamentoService {
	
	ResponseEntity<?> cadastrar(RelacionamentoTopico relacionamento);
	ResponseEntity<?> buscar(Integer id);
	ResponseEntity<?> atualizar(Integer id, RelacionamentoTopico relacionamentoAlterar);
	ResponseEntity<?> deletar(Integer id);

}

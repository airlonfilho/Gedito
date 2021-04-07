package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.PreRequisito;

public interface PreRequisitoService {

	ResponseEntity<?> cadastrar(PreRequisito preReq);
	ResponseEntity<?> buscar(Integer id);
	ResponseEntity<?> atualizar(Integer id, PreRequisito preReqAlterar);
	ResponseEntity<?> deletar(Integer id);
	
}

package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Topico;

public interface TopicoService {
	
	ResponseEntity<?> cadastrar(Topico topico);
	ResponseEntity<?> buscar(Integer id);
	ResponseEntity<?> atualizar(Integer id, Topico topicoAlterar);
	ResponseEntity<?> deletar(Integer id);

}

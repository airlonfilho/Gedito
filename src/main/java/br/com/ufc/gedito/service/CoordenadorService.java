package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Coordenador;

public interface CoordenadorService {

	ResponseEntity<?> cadastrar(Coordenador coordenador);
	ResponseEntity<?> buscar(Integer siape);
	ResponseEntity<?> atualizar(Integer siape, Coordenador coordenadorAlterar);
	ResponseEntity<?> deletar(Integer siape);
	
}

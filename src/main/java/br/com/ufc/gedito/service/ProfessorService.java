package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Professor;

public interface ProfessorService {

	ResponseEntity<?> cadastrar(Professor professor);
	ResponseEntity<?> buscar(Integer siape);
	ResponseEntity<?> buscar();
	ResponseEntity<?> atualizar(Integer siape, Professor professorAlterar);
	ResponseEntity<?> deletar(Integer siape);
	
}

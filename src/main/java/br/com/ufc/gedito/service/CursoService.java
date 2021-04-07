package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Curso;

public interface CursoService {

	ResponseEntity<?> cadastrar(Curso curso);
	ResponseEntity<?> buscar(Integer id);
	ResponseEntity<?> buscar();
	ResponseEntity<?> atualizar(Integer id, Curso cursoAlterar);
	ResponseEntity<?> deletar(Integer id);
	
}

package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Disciplina;

public interface DisciplinaService {
	
	ResponseEntity<?> cadastrar(Disciplina disciplina);
	ResponseEntity<?> buscar(Integer id);
	ResponseEntity<?> buscar();
	ResponseEntity<?> atualizar(Integer id, Disciplina disciplinaAlterar);
	ResponseEntity<?> deletar(Integer id);

}

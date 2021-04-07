package br.com.ufc.gedito.service;

import org.springframework.http.ResponseEntity;

import br.com.ufc.gedito.entity.Aluno;

public interface AlunoService {
	
	ResponseEntity<?> cadastrar(Aluno aluno);
	ResponseEntity<?> buscar(Integer matricula);
	ResponseEntity<?> buscar();
	ResponseEntity<?> atualizar(Integer matricula, Aluno alunoAlterar);
	ResponseEntity<?> deletar(Integer matricula);
	
}

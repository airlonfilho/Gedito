package br.com.ufc.gedito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Aluno;
import br.com.ufc.gedito.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public ResponseEntity<?> cadastrar(Aluno aluno) {
		try {
			if (!alunoRepository.existsByMatriculaAndCurso(aluno.getMatricula(), aluno.getCurso())) {
				alunoRepository.save(aluno);
				return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aluno já cadastrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer matricula) {
		try {
			if(alunoRepository.existsByMatricula(matricula)) {
				Aluno aluno = alunoRepository.findByMatricula(matricula);
				return ResponseEntity.status(HttpStatus.OK).body(aluno);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aluno não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@Override
	public ResponseEntity<?> buscar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(alunoRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer matricula, Aluno alunoAlterar) {
		try {
			if(alunoRepository.existsByMatricula(matricula)) {
				Aluno alunoAtual = alunoRepository.findByMatricula(matricula);
				alunoAtual.setCurso(alunoAlterar.getCurso());
				alunoAtual.setNome(alunoAlterar.getNome());
				alunoAtual.setSenha(alunoAlterar.getSenha());
				
				alunoRepository.save(alunoAtual);
				
				return ResponseEntity.status(HttpStatus.OK).body(alunoAtual);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aluno não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer matricula) {
		try {
			if(alunoRepository.existsByMatricula(matricula) ) {
				alunoRepository.deleteByMatricula(matricula);
				return ResponseEntity.status(HttpStatus.OK).body("Aluno com matrícula" + matricula + "deletado");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Aluno não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

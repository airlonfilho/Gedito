package br.com.ufc.gedito.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Curso;
import br.com.ufc.gedito.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public ResponseEntity<?> cadastrar(Curso curso) {
		try {
			if(!cursoRepository.existsByNome(curso.getNome())) {
				cursoRepository.save(curso);
				return ResponseEntity.status(HttpStatus.CREATED).body(curso);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso já cadastrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer id) {
		try {
			if(cursoRepository.existsById(id)) {
				Optional<Curso> curso = cursoRepository.findById(id);
				return ResponseEntity.status(HttpStatus.OK).body(curso.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@Override
	public ResponseEntity<?> buscar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(cursoRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer id, Curso cursoAlterar) {
		try {
			if(cursoRepository.existsById(id)) {
				Optional<Curso> curso = cursoRepository.findById(id);
				
				curso.get().setNome(cursoAlterar.getNome());				
				cursoRepository.save(curso.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(curso.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer id) {
		try {
			if(cursoRepository.existsById(id)) {
				cursoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).body("Curso com id " + id + " deletado.");
			}else { 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Curso não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

package br.com.ufc.gedito.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Disciplina;
import br.com.ufc.gedito.repository.DisciplinaRepository;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public ResponseEntity<?> cadastrar(Disciplina disciplina) {
		try {
			if(!disciplinaRepository.existsByNome(disciplina.getNome())) {
				disciplinaRepository.save(disciplina);
				return ResponseEntity.status(HttpStatus.CREATED).body(disciplina);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Disciplina já cadastrada.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer id) {
		try {
			if(disciplinaRepository.existsById(id)) {
				Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body(disciplina.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Disciplina não encontrada.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@Override
	public ResponseEntity<?> buscar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(disciplinaRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer id, Disciplina disciplinaAlterar) {
		try {
			if(disciplinaRepository.existsById(id)) {
				Optional<Disciplina> disciplina = disciplinaRepository.findById(id);
				disciplina.get().setNome(disciplinaAlterar.getNome());
				disciplina.get().setPreRequisitos(disciplinaAlterar.getPreRequisitos());
				disciplina.get().setSemestre(disciplinaAlterar.getSemestre());
				disciplina.get().setTopicos(disciplinaAlterar.getTopicos());
				
				disciplinaRepository.save(disciplina.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(disciplina.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Disciplina não encontrada.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer id) {
		try {
			if(disciplinaRepository.existsById(id)) {
				disciplinaRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body("Disciplina com id " +id+ " deletada.");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Disciplina não encontrada.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
}

package br.com.ufc.gedito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Professor;
import br.com.ufc.gedito.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public ResponseEntity<?> cadastrar(Professor professor) {
		try {
			if (!professorRepository.existsBySiape(professor.getSiape())) {	
				professorRepository.save(professor);
				return ResponseEntity.status(HttpStatus.CREATED).body(professor);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor já cadastrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer siape) {
		try {
			if (professorRepository.existsBySiape(siape)) {
				Professor professor = professorRepository.findBySiape(siape);
				return ResponseEntity.status(HttpStatus.OK).body(professor);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(professorRepository.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	@Override
	public ResponseEntity<?> atualizar(Integer siape, Professor professorAlterar) {
		try {
			if (professorRepository.existsBySiape(siape)) {
				Professor professor = professorRepository.findBySiape(siape);
				professor.setNome(professorAlterar.getNome());
				professor.setSenha(professorAlterar.getSenha());
				professor.setSiape(professorAlterar.getSiape());
				
				professorRepository.save(professor);
				
				return ResponseEntity.status(HttpStatus.OK).body(professor);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer siape) {
		try {
			if (professorRepository.existsBySiape(siape)) {
				professorRepository.deleteBySiape(siape);
				return ResponseEntity.status(HttpStatus.OK).body("Professor com siape " +siape+ "deletado.");
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

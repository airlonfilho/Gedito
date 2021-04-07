package br.com.ufc.gedito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Coordenador;
import br.com.ufc.gedito.entity.Curso;
import br.com.ufc.gedito.entity.Professor;
import br.com.ufc.gedito.repository.CoordenadorRepository;
import br.com.ufc.gedito.repository.CursoRepository;
import br.com.ufc.gedito.repository.ProfessorRepository;

@Service
public class CoordenadorServiceImpl implements CoordenadorService {

	@Autowired
	private CoordenadorRepository coordenadorRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Override
	public ResponseEntity<?> cadastrar(Coordenador coordenador) {
		try {
			if (professorRepository.existsByNome(coordenador.getProfessor())
					&& cursoRepository.existsByNome(coordenador.getCurso())) {

				Professor professor = professorRepository.findByNome(coordenador.getProfessor());
				Curso curso = cursoRepository.findByNome(coordenador.getCurso());

				if (!coordenadorRepository.existsByProfessorAndCurso(professor.getNome(), curso.getNome())) {
					coordenadorRepository.save(coordenador);
					return ResponseEntity.status(HttpStatus.CREATED).body(coordenador);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenador já cadastrado.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor ou curso não encontrado.");
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

				if (coordenadorRepository.existsByProfessor(professor.getNome())) {
					Coordenador coordenador = coordenadorRepository.findByProfessor(professor.getNome());
					return ResponseEntity.status(HttpStatus.OK).body(coordenador);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenador não encontrado.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer siape, Coordenador coordenadorAlterar) {
		try {
			if(professorRepository.existsBySiape(siape) && cursoRepository.existsByNome(coordenadorAlterar.getCurso())) {
				Professor professor = professorRepository.findBySiape(siape);
				Curso curso = cursoRepository.findByNome(coordenadorAlterar.getCurso());
				
				if(coordenadorRepository.existsByProfessor(professor.getNome())) {
					Coordenador coordenador = coordenadorRepository.findByProfessor(professor.getNome());
					coordenador.setCurso(curso.getNome());
					coordenador.setProfessor(professor.getNome());
					
					coordenadorRepository.save(coordenador);
					
					return ResponseEntity.status(HttpStatus.OK).body(coordenador);
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenador não encontrado.");
				}
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor ou curso não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer siape) {
		try {
			if (professorRepository.existsBySiape(siape)) {
				Professor professor = professorRepository.findBySiape(siape);

				if (coordenadorRepository.existsByProfessor(professor.getNome())) {
					Coordenador coordenador = coordenadorRepository.findByProfessor(professor.getNome());
					
					coordenadorRepository.deleteByProfessor(professor.getNome());
					
					return ResponseEntity.status(HttpStatus.OK).body(coordenador);
				} else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coordenador não encontrado.");
				}
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor não encontrado.");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

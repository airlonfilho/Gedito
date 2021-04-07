package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer>{
	
	Coordenador findByProfessorAndCurso(String professor, String curso);
	Coordenador findByProfessor(String professor);
	boolean existsByProfessorAndCurso(String professor, String curso);
	boolean existsByProfessor(String professor);
	void deleteByProfessor(String professor);
	
}

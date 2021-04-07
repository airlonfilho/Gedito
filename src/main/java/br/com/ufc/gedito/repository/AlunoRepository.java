package br.com.ufc.gedito.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{
	
	Aluno findByMatricula(Integer matricula);
	boolean existsByMatriculaAndCurso(Integer matricula, String curso);
	boolean existsByMatricula(Integer matricula);
	void deleteByMatricula(Integer matricula);

}

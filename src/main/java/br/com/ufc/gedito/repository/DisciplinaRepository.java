package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
	
	Disciplina findByIdAndNome(Integer id, String nome);
	boolean existsByIdAndNome(Integer id, String nome);
	boolean existsById(Integer id);
	Disciplina findByNome(String nome);
	boolean existsByNome(String nome);

}

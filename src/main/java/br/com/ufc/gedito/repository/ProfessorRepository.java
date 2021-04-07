package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>{
	
	Professor findBySiape(Integer siape);
	Professor findByNome(String nome);
	boolean existsBySiape(Integer siape);
	boolean existsByNome(String nome);
	void deleteBySiape(Integer siape);
	
}

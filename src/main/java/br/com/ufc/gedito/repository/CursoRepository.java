package br.com.ufc.gedito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	
	Curso findByIdAndNome(Integer id, String nome);
	Optional<Curso> findById(Integer id);
	boolean existsByIdAndNome(Integer id, String nome);
	Curso findByNome(String nome);
	boolean existsByNome(String nome);
	boolean existsById(Integer id);
}

package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.Topico;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Integer>{

}

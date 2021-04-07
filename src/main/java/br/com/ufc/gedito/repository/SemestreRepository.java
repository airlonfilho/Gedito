package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.ufc.gedito.entity.Semestre;

@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Integer>{

}

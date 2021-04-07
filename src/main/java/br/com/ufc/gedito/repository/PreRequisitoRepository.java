package br.com.ufc.gedito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufc.gedito.entity.PreRequisito;
import br.com.ufc.gedito.entity.RelacionamentoTopico;

@Repository
public interface PreRequisitoRepository extends JpaRepository<PreRequisito, Integer> {

}

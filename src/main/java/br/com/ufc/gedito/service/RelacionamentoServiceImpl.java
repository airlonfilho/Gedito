package br.com.ufc.gedito.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.RelacionamentoTopico;
import br.com.ufc.gedito.repository.RelacionamentoRepository;

@Service
public class RelacionamentoServiceImpl implements RelacionamentoService {
	
	@Autowired
	private RelacionamentoRepository relacionamentoRepository;

	@Override
	public ResponseEntity<?> cadastrar(RelacionamentoTopico relacionamento) {
		try {
			if(!relacionamentoRepository.existsById(relacionamento.getId())) {
				relacionamentoRepository.save(relacionamento);
				return ResponseEntity.status(HttpStatus.CREATED).body(relacionamento);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Relacionamento já cadastrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer id) {
		try {
			if(relacionamentoRepository.existsById(id)) {
				Optional<RelacionamentoTopico> relacionamento = relacionamentoRepository.findById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body(relacionamento.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Relacionamento não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer id, RelacionamentoTopico relacionamentoAlterar) {
		try {
			if(relacionamentoRepository.existsById(id)) {
				Optional<RelacionamentoTopico> relacionamento = relacionamentoRepository.findById(id);
				relacionamento.get().setTopico(relacionamentoAlterar.getTopico());
				
				relacionamentoRepository.save(relacionamento.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(relacionamento.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Relacionamento não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer id) {
		try {
			if(relacionamentoRepository.existsById(id)) {
				relacionamentoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body("Relacionamento com id " +id+ " deletado.");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Relacionamento não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

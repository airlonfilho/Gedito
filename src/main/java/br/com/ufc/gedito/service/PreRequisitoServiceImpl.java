package br.com.ufc.gedito.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.PreRequisito;
import br.com.ufc.gedito.repository.PreRequisitoRepository;

@Service
public class PreRequisitoServiceImpl implements PreRequisitoService {
	
	@Autowired
	private PreRequisitoRepository preRequisitoRepository;

	@Override
	public ResponseEntity<?> cadastrar(PreRequisito preReq) {
		try {
			if(!preRequisitoRepository.existsById(preReq.getId())) {
				preRequisitoRepository.save(preReq);
				return ResponseEntity.status(HttpStatus.CREATED).body(preReq);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pré requisito já cadastrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer id) {
		try {
			if(preRequisitoRepository.existsById(id)) {
				Optional<PreRequisito> preReq = preRequisitoRepository.findById(id);
				return ResponseEntity.status(HttpStatus.OK).body(preReq.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pré requisito não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer id, PreRequisito preReqAlterar) {
		try {
			if(preRequisitoRepository.existsById(id)) {
				Optional<PreRequisito> preReq = preRequisitoRepository.findById(id);
				preReq.get().setDisciplina(preReqAlterar.getDisciplina());
				preRequisitoRepository.save(preReq.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(preReq.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pré requisito não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer id) {
		try {
			if(preRequisitoRepository.existsById(id)) {
				preRequisitoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.OK).body("Pré requisito com id " +id+ " deletado.");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Pré requisito não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	
}

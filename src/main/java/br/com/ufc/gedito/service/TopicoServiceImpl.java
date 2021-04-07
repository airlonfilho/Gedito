package br.com.ufc.gedito.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ufc.gedito.entity.Topico;
import br.com.ufc.gedito.repository.TopicoRepository;

@Service
public class TopicoServiceImpl implements TopicoService {
	
	@Autowired
	private TopicoRepository topicoRepository;

	@Override
	public ResponseEntity<?> cadastrar(Topico topico) {
		try {
			if(!topicoRepository.existsById(topico.getId())) {
				topicoRepository.save(topico);
				return ResponseEntity.status(HttpStatus.CREATED).body(topico);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tópico já cadastrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> buscar(Integer id) {
		try {
			if(topicoRepository.existsById(id)) {
				Optional<Topico> topico = topicoRepository.findById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body(topico.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tópico não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> atualizar(Integer id, Topico topicoAlterar) {
		try {
			if(topicoRepository.existsById(id)) {
				Optional<Topico> topico = topicoRepository.findById(id);
				topico.get().setDescricao(topicoAlterar.getDescricao());
				topico.get().setDisciplinas(topicoAlterar.getDisciplinas());
				topico.get().setNome(topicoAlterar.getNome());
				topico.get().setRelacionamento_topico(topicoAlterar.getRelacionamento_topico());
				
				topicoRepository.save(topico.get());
				
				return ResponseEntity.status(HttpStatus.OK).body(topico.get());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tópico não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<?> deletar(Integer id) {
		try {
			if(topicoRepository.existsById(id)) {
				topicoRepository.deleteById(id);
				return ResponseEntity.status(HttpStatus.CREATED).body("Tópico com id " +id+ " deletado.");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tópico não encontrado.");
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}

package br.com.ufc.gedito.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ufc.gedito.entity.PreRequisito;
import br.com.ufc.gedito.service.PreRequisitoService;

@RestController
@RequestMapping("/gedito/prerequisitos")
public class PreRequisitoController {
	
	@Autowired
	private PreRequisitoService preReqService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody PreRequisito preReq) {
		return preReqService.cadastrar(preReq);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		return preReqService.buscar(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody PreRequisito preReq) {
		return preReqService.atualizar(id, preReq);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return preReqService.deletar(id);
	}

}

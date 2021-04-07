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

import br.com.ufc.gedito.entity.RelacionamentoTopico;
import br.com.ufc.gedito.service.RelacionamentoService;

@RestController
@RequestMapping("/gedito/relacionamentos")
public class RelacionamentoController {
	
	@Autowired
	private RelacionamentoService relacionamentoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody RelacionamentoTopico relacionamento) {
		return relacionamentoService.cadastrar(relacionamento);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		return relacionamentoService.buscar(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody RelacionamentoTopico relacionamento) {
		return relacionamentoService.atualizar(id, relacionamento);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return relacionamentoService.deletar(id);
	}

}

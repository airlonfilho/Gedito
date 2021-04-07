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

import br.com.ufc.gedito.entity.Topico;
import br.com.ufc.gedito.service.TopicoService;

@RestController
@RequestMapping("/gedito/topicos")
public class TopicoRestController {

	@Autowired
	private TopicoService topicoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Topico topico) {
		return topicoService.cadastrar(topico);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		return topicoService.buscar(id);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Topico topico) {
		return topicoService.atualizar(id, topico);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return topicoService.deletar(id);
	}
	
}

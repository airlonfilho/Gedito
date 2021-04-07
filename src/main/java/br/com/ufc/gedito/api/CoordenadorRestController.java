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

import br.com.ufc.gedito.entity.Coordenador;
import br.com.ufc.gedito.service.CoordenadorService;

@RestController
@RequestMapping("/gedito/coordenadores")
public class CoordenadorRestController {
	
	@Autowired
	private CoordenadorService coordenadorService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Coordenador coordenador) {
		return coordenadorService.cadastrar(coordenador);
	}
	
	@GetMapping("/{siape}")
	public ResponseEntity<?> buscar(@PathVariable Integer siape) {
		return coordenadorService.buscar(siape);
	}
	
	@PutMapping("{siape}")
	public ResponseEntity<?> atualizar(@PathVariable Integer siape, @RequestBody Coordenador coordenador) {
		return coordenadorService.atualizar(siape, coordenador);
	}
	
	@DeleteMapping("/siape")
	public ResponseEntity<?> deletar(@PathVariable Integer siape) {
		return coordenadorService.deletar(siape);
	}

}

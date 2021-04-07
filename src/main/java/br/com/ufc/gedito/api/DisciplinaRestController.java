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

import br.com.ufc.gedito.entity.Disciplina;
import br.com.ufc.gedito.service.DisciplinaService;

@RestController
@RequestMapping("/gedito/disciplinas")
public class DisciplinaRestController {
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Disciplina disciplina) {
		return disciplinaService.cadastrar(disciplina);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		return disciplinaService.buscar(id);
	}
	
	@GetMapping
	public ResponseEntity<?> buscar() {
		return disciplinaService.buscar();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
		return disciplinaService.atualizar(id, disciplina);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return disciplinaService.deletar(id);
	}

}

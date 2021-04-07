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

import br.com.ufc.gedito.entity.Curso;
import br.com.ufc.gedito.service.CursoService;

@RestController
@RequestMapping("/gedito/cursos")
public class CursoRestController {
	
	@Autowired
	private CursoService cursoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Curso curso) {
		return cursoService.cadastrar(curso);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		return cursoService.buscar(id);
	}
	
	@GetMapping()
	public ResponseEntity<?> buscar() {
		return cursoService.buscar();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@PathVariable Integer id, @RequestBody Curso curso) {
		return cursoService.atualizar(id, curso);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		return cursoService.deletar(id);
	}

}

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

import br.com.ufc.gedito.entity.Professor;
import br.com.ufc.gedito.service.ProfessorService;

@RestController
@RequestMapping("/gedito/professores")
public class ProfessorRestController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Professor professor) {
		return professorService.cadastrar(professor);
	}
	
	@GetMapping("/{siape}")
	public ResponseEntity<?> buscar(@PathVariable Integer siape) {
		return professorService.buscar(siape);
	}
	
	@GetMapping
	public ResponseEntity<?> buscar() {
		return professorService.buscar();
	}
	
	@PutMapping("{siape}")
	public ResponseEntity<?> atualizar(@PathVariable Integer siape, @RequestBody Professor professor) {
		return professorService.atualizar(siape, professor);
	}
	
	@DeleteMapping("/siape")
	public ResponseEntity<?> deletar(@PathVariable Integer siape) {
		return professorService.deletar(siape);
	}

}

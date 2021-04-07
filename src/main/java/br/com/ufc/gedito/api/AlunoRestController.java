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

import br.com.ufc.gedito.entity.Aluno;
import br.com.ufc.gedito.service.AlunoService;

@RestController
@RequestMapping("/gedito/alunos")
public class AlunoRestController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Aluno aluno) {
		return alunoService.cadastrar(aluno);
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<?> buscar(@PathVariable Integer matricula) {
		return alunoService.buscar(matricula);
	}
	
	@GetMapping
	public ResponseEntity<?> buscar() {
		return alunoService.buscar();
	}
	
	@PutMapping("{matricula}")
	public ResponseEntity<?> atualizar(@PathVariable Integer matricula, @RequestBody Aluno aluno) {
		return alunoService.atualizar(matricula, aluno);
	}
	
	@DeleteMapping("/matricula")
	public ResponseEntity<?> deletar(@PathVariable Integer matricula) {
		return alunoService.deletar(matricula);
	}

}

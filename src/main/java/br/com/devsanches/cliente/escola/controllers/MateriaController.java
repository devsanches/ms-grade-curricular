package br.com.devsanches.cliente.escola.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.devsanches.cliente.escola.entities.MateriaEntity;
import br.com.devsanches.cliente.escola.repositories.IMateriaRepository;
import br.com.devsanches.cliente.escola.services.MateriaService;

@RestController
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	IMateriaRepository materiaRepository;
	
	@Autowired
	MateriaService materiaService;
	
	
	@GetMapping()
	public ResponseEntity<List<MateriaEntity>> listarMaterias() {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.buscar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MateriaEntity> consultarMateria(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Boolean> cadastrarMateria(@RequestBody MateriaEntity materia) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.cadastrar(materia));
	}
	
	
	@PutMapping
	public ResponseEntity<Boolean> atualizarMateria(@RequestBody MateriaEntity materia) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.atualizar(materia));	
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirMateria(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(this.materiaService.excluir(id));
	}
	
}

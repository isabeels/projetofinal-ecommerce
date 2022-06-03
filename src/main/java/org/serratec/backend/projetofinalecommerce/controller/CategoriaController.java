package org.serratec.backend.projetofinalecommerce.controller;

import java.util.List;

import org.serratec.backend.projetofinalecommerce.dto.CategoriaDTO;
import org.serratec.backend.projetofinalecommerce.entity.Categoria;
import org.serratec.backend.projetofinalecommerce.exceptions.CategoriaException;
import org.serratec.backend.projetofinalecommerce.service.CategoriaService;
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

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping("/salvar-categoria")
	public ResponseEntity<Object> salvar(@RequestBody CategoriaDTO categoriaDto) throws CategoriaException {
		categoriaService.salvar(categoriaDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso.");
	}

	@PostMapping("/salvar-lista-categoria")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CategoriaDTO> listaCategoria) {
		categoriaService.salvarListaCategoria(listaCategoria);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/buscar-categoria/{idCategoria}")
	public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Integer idCategoria) throws CategoriaException {
		return ResponseEntity.ok(categoriaService.buscarPorId(idCategoria));
	}

	@GetMapping("/buscar-lista-categoria")
	public ResponseEntity<List<Categoria>> listarTodos() {
		return ResponseEntity.ok(categoriaService.buscarTodos());
	}

	@PutMapping("/atualizar-categoria/{idCategoria}")
	public ResponseEntity<Void> atualizar(@PathVariable Integer idCategoria, @RequestBody CategoriaDTO categoriaDto) {
		categoriaService.atualizarCategoria(idCategoria, categoriaDto);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deletar-categoria/{idCategoria}")
	public ResponseEntity<Void> deletarCategoria(@PathVariable Integer idCategoria) {
		categoriaService.deletarPorId(idCategoria);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}

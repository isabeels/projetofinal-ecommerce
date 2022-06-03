package org.serratec.backend.projetofinalecommerce.controller;

import java.util.List;

import org.serratec.backend.projetofinalecommerce.dto.ProdutoDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.ProdutoException;
import org.serratec.backend.projetofinalecommerce.service.ProdutoService;
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
@RequestMapping ("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/buscar-todos")
	public ResponseEntity<List<ProdutoDTO>> buscarTodos(){
		return ResponseEntity.ok(produtoService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idProduto}")
	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Integer idProduto) throws ProdutoException{
		return ResponseEntity.ok(produtoService.buscarPorId(idProduto));
	}

	@PostMapping("/salvar")
	public ResponseEntity<String> salvarProduto(@RequestBody ProdutoDTO produtoDTO) throws ProdutoException {
		return ResponseEntity.ok(produtoService.salvarProduto(produtoDTO));
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarListaProduto(@RequestBody List<ProdutoDTO> listaProduto) {
		produtoService.salvarListaProduto(listaProduto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{idProduto}")
	public ResponseEntity<String> atualizarProduto(@PathVariable Integer idProduto,@RequestBody ProdutoDTO produtoDTO) throws ProdutoException{
		return ResponseEntity.ok(produtoService.atualizarProduto(idProduto, produtoDTO));
	}

	@DeleteMapping("/deletar/{idProduto}")
	public ResponseEntity<String> deletarPorId(@PathVariable Integer idProduto) throws ProdutoException {
	return ResponseEntity.ok(produtoService.deletarPorId(idProduto));
	}
	
}

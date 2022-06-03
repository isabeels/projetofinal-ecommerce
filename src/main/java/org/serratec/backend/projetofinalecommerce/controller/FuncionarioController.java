package org.serratec.backend.projetofinalecommerce.controller;

import java.util.List;

import org.serratec.backend.projetofinalecommerce.dto.FuncionarioDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.FuncionarioException;
import org.serratec.backend.projetofinalecommerce.service.FuncionarioService;
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
@RequestMapping ("/funcionario")
public class FuncionarioController {

	@Autowired
	FuncionarioService funcionarioService;
	
	@GetMapping("/buscar-todos")
	public ResponseEntity<List<FuncionarioDTO>> buscarTodos(){
		return ResponseEntity.ok(funcionarioService.buscarTodos());
	}
	
	@GetMapping("/buscar/{idFuncionario}")
	public ResponseEntity<FuncionarioDTO> buscarPorId(@PathVariable Integer idFuncionario) throws FuncionarioException{
		return ResponseEntity.ok(funcionarioService.buscarPorId(idFuncionario));
	}

	@PostMapping("/salvar")
	public ResponseEntity<String> salvarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioException {
		return ResponseEntity.ok(funcionarioService.salvarFuncionario(funcionarioDTO));
	}

	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarListaFuncionario(@RequestBody List<FuncionarioDTO> listaFuncionario) {
		funcionarioService.salvarListaFuncionario(listaFuncionario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/atualizar/{idFuncionario}")
	public ResponseEntity<String> atualizarFuncionario(@PathVariable Integer idFuncionario,@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioException{
		return ResponseEntity.ok(funcionarioService.atualizarFuncionario(idFuncionario, funcionarioDTO));
	}

	@DeleteMapping("/deletar/{idFuncionario}")
	public ResponseEntity<String> deletarPorId(@PathVariable Integer idFuncionario) throws FuncionarioException {
	return ResponseEntity.ok(funcionarioService.deletarPorId(idFuncionario));
	}
}

package org.serratec.backend.projetofinalecommerce.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratec.backend.projetofinalecommerce.dto.PedidoDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.EmailException;
import org.serratec.backend.projetofinalecommerce.exceptions.PedidoException;
import org.serratec.backend.projetofinalecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	PedidoService pedidoService;

	@GetMapping("/buscar-todos")
	public ResponseEntity<List<PedidoDTO>> listarTodos() {
		return ResponseEntity.ok(pedidoService.listarTodos());
	}

	@GetMapping("/buscar/{idPedido}")
	public ResponseEntity<PedidoDTO> buscarPorId(@PathVariable Integer idPedido) throws PedidoException {
		return ResponseEntity.ok(pedidoService.buscarPorId(idPedido));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Void> salvarPedido(@RequestBody PedidoDTO pedidoDTO) throws Exception {
		pedidoService.salvar(pedidoDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/deletar/{idPedido}")
	public ResponseEntity<String> deletarPorId(@PathVariable Integer idPedido) throws PedidoException {
		return ResponseEntity.ok(pedidoService.deletarPorId(idPedido));
	}

}

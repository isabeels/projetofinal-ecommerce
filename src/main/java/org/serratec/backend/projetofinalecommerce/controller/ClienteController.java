package org.serratec.backend.projetofinalecommerce.controller;

import io.swagger.models.Response;
import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.serratec.backend.projetofinalecommerce.dto.ClienteDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.ClienteException;
import org.serratec.backend.projetofinalecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<ClienteDTO>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }


    @GetMapping("/buscar/{idCliente}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Integer idCliente) throws ClienteException {
        return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
    }


	@PostMapping("/salvar-cliente")
    public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) {
        return ResponseEntity.ok(clienteService.salvar(clienteDTO));
    }

    @PostMapping("/salvar-lista-entidade")
    public ResponseEntity<Void> salvarLista(@RequestBody List<ClienteDTO> listaCliente) {
        clienteService.salvarLista(listaCliente);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @PutMapping("/atualizar/{idCliente}")
    public ResponseEntity<String> atualizar(
            @PathVariable Integer idCliente,
            @RequestBody ClienteDTO clienteDTO
            ) throws ClienteException {
        return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
    }

    @DeleteMapping("/deletar/{idCliente}")
    public ResponseEntity<String> deletar(@PathVariable Integer idCliente) throws ClienteException {
        return ResponseEntity.ok(clienteService.deletar(idCliente));
    }



}

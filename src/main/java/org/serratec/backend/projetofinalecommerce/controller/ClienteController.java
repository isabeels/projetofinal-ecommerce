package org.serratec.backend.projetofinalecommerce.controller;

import org.serratec.backend.projetofinalecommerce.dto.ClienteDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.ClienteException;
import org.serratec.backend.projetofinalecommerce.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;


	@GetMapping("/listarTodos")
    public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) throws ClienteException {
        return ResponseEntity.ok(clienteService.salvar(clienteDTO));
    }

    //@GetMapping("/listar/{idCliente}")
    //@PostMapping("/")
    //@PostMapping("")
    //@PutMapping("/")
    //@PutMapping("/")
    //@DeleteMapping("/")
    //@DeleteMapping("/")

}

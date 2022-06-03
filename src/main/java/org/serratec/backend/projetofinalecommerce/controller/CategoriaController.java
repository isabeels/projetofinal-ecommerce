package org.serratec.backend.projetofinalecommerce.controller;

import org.serratec.backend.projetofinalecommerce.dto.CategoriaDTO;
import org.serratec.backend.projetofinalecommerce.exceptions.CategoriaException;
import org.serratec.backend.projetofinalecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
//	@Autowired
//	CategoriaService categoriaService;
//	
//	@PostMapping("/salvar")
//	public ResponseEntity<Void> salvar(@RequestBody CategoriaDTO categoriaDto) throws CategoriaException{
//		categoria
//	}
}

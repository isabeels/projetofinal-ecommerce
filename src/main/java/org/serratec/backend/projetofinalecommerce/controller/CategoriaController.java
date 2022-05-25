package org.serratec.backend.projetofinalecommerce.controller;

import org.serratec.backend.projetofinalecommerce.dto.CategoriaDTO;
import org.serratec.backend.projetofinalecommerce.entity.Categoria;
import org.serratec.backend.projetofinalecommerce.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> saveCategoria (@RequestBody /*@Valid*/ CategoriaDTO categoriaDto) {
        var categoriaEntity = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoriaEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaEntity));
    }
}

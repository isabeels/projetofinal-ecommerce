package org.serratec.backend.projetofinalecommerce.service;

import org.serratec.backend.projetofinalecommerce.entity.Categoria;
import org.serratec.backend.projetofinalecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

	public Categoria save(Categoria categoriaEntity) {
		return categoriaRepository.save(categoriaEntity);
	}

    
}

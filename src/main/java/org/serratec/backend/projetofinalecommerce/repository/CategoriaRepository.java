package org.serratec.backend.projetofinalecommerce.repository;

import org.serratec.backend.projetofinalecommerce.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}

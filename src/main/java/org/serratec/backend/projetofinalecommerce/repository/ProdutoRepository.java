package org.serratec.backend.projetofinalecommerce.repository;

import java.util.UUID;

import org.serratec.backend.projetofinalecommerce.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}

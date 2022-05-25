package org.serratec.backend.projetofinalecommerce.repository;

import java.util.UUID;

import org.serratec.backend.projetofinalecommerce.entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

}

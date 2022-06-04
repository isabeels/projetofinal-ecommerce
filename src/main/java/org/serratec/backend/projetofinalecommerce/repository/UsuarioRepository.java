package org.serratec.backend.projetofinalecommerce.repository;

import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value="FROM Usuario u WHERE u.username = ?1")
	Optional<Usuario> buscarPorUsername(String username);
		
}

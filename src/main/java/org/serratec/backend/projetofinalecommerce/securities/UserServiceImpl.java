package org.serratec.backend.projetofinalecommerce.securities;

import java.util.ArrayList;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.entity.Usuario;
import org.serratec.backend.projetofinalecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.buscarPorUsername(username);

		if (usuario.isPresent()) {
			Usuario usuarioNoBanco = usuario.get();
			return new User(usuarioNoBanco.getUsername(), usuarioNoBanco.getPassword(), new ArrayList<>());
		}

		throw new UsernameNotFoundException("Usuário não encontrado / User not found.");
	}

}

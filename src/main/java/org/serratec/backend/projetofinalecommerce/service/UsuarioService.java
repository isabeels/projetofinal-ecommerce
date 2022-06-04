package org.serratec.backend.projetofinalecommerce.service;

import org.serratec.backend.projetofinalecommerce.dto.UsuarioDTO;
import org.serratec.backend.projetofinalecommerce.entity.Usuario;
import org.serratec.backend.projetofinalecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	private UsuarioDTO transformarEntityEmDto(Usuario usuario, UsuarioDTO usuarioDto) {
		usuarioDto.setIdUsuario(usuario.getIdUsuario());
		usuarioDto.setUsername(usuario.getUsername());
		usuarioDto.setPassword(usuario.getPassword());
		return usuarioDto;
	}
	
	private Usuario transformarDtoEmEntity (UsuarioDTO usuarioDto, Usuario usuario) {
		usuario.setUsername(usuarioDto.getUsername());
		usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
		return usuario;
	}
}

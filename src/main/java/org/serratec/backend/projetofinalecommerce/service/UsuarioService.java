package org.serratec.backend.projetofinalecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratec.backend.projetofinalecommerce.dto.UsuarioDTO;
import org.serratec.backend.projetofinalecommerce.entity.Usuario;
import org.serratec.backend.projetofinalecommerce.exceptions.UsuarioException;
import org.serratec.backend.projetofinalecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	private Usuario transformarDtoEmEntity(UsuarioDTO usuarioDto, Usuario usuario) {
		usuario.setUsername(usuarioDto.getUsername());
		usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
		return usuario;
	}

	public String salvarUsuario(UsuarioDTO usuarioDto) {
		Usuario usuario = new Usuario();
		transformarDtoEmEntity(usuarioDto, usuario);
		usuarioRepository.save(usuario);
		return "Usuário ID: " + usuario.getIdUsuario() + " Nome: " + usuario.getUsername() + " Criado com sucesso.";
	}

	public UsuarioDTO buscarPorId(Integer idUsuario) throws UsuarioException {
		Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
		Usuario usuarioNoBanco = new Usuario();
		UsuarioDTO usuarioDto = new UsuarioDTO();
		if (usuario.isPresent()) {
			usuarioNoBanco = usuario.get();
			transformarEntityEmDto(usuarioNoBanco, usuarioDto);
			return usuarioDto;
		}
		throw new UsuarioException("O id informado não foi encontrado!");
	}

	public List<UsuarioDTO> buscarTodos() {
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();

		for (Usuario usuario : listaUsuario) {
			UsuarioDTO usuarioDto = new UsuarioDTO();
			transformarEntityEmDto(usuario, usuarioDto);
			listaUsuarioDTO.add(usuarioDto);
		}
		return listaUsuarioDTO;
	}

	public UsuarioDTO buscarPorLogin(String username) {
		return usuarioRepository.findAll()
				.stream()
				.filter(usuario -> usuario.getUsername().equals(username))
				.map(usuario -> transformarEntityEmDto(usuario, new UsuarioDTO()))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
}

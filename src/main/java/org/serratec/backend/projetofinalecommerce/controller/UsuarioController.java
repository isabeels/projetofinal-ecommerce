package org.serratec.backend.projetofinalecommerce.controller;

import javax.validation.Valid;

import org.serratec.backend.projetofinalecommerce.dto.UsuarioDTO;
import org.serratec.backend.projetofinalecommerce.securities.JwtUtil;
import org.serratec.backend.projetofinalecommerce.securities.UserServiceImpl;
import org.serratec.backend.projetofinalecommerce.securities.UsuarioAuthenticationRequest;
import org.serratec.backend.projetofinalecommerce.securities.UsuarioAuthenticationResponse;
import org.serratec.backend.projetofinalecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> criarAutenticacao(@RequestBody UsuarioAuthenticationRequest usuario) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(usuario.getUsername(), usuario.getPassword()));
		} catch (Exception e) {
			throw new Exception("Credencias incorretas", e);
		}

		UserDetails usuarioDetalhe = userServiceImpl.loadUserByUsername(usuario.getUsername());
		String token = jwtUtil.generateToken(usuarioDetalhe);
		return ResponseEntity.ok(new UsuarioAuthenticationResponse(token));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Integer> salvarUsuario(@RequestBody @Valid UsuarioDTO usuarioDto) {
		return ResponseEntity.ok(usuarioService.salvarUsuario(usuarioDto));
	}

	@GetMapping
	public ResponseEntity<UsuarioDTO> buscarUsuario(@RequestParam String username) {
		return ResponseEntity.ok(usuarioService.buscarPorLogin(username));
	}
}

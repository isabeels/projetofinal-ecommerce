package org.serratec.backend.projetofinalecommerce.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idUsuario;
	private String username;
	private String password;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(Integer idUsuario, String username, String password) {
		super();
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

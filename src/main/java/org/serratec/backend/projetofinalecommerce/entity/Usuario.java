package org.serratec.backend.projetofinalecommerce.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	@NotBlank
	private Integer idUsuario;

	@Column(name = "usuario_login")
	@NotBlank
	private String username;

	@Column(name = "usuario_senha")
	@NotBlank
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(@NotBlank Integer idUsuario, @NotBlank String username, @NotBlank String password) {
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
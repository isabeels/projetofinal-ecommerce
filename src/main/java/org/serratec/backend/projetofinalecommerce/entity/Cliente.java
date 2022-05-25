package org.serratec.backend.projetofinalecommerce.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cliente_cd_id")
	private UUID idCliente;

	
	@Column(name="cliente_tx_nomeCompleto")
	private String nomeCompleto;
	
	@Column(name="cliente_tx_nomeUsuario")
	private String nomeUsuario;
	
	@Column(name="cliente_tx_email")
	private String email;
	
	@Column(name="cliente_tx_cpf")
	private Integer cpf;
	
	@Column(name="cliente_dt_nascimento")
	private Date dataNascimento;
	
	@Column(name="cliente_tx_endereco")
	private String endereco;
	
	@Column(name="cliente_tx_numero_telefone")
	private Integer telefone;
	
	
	//Construtores
	
	public Cliente() {}
	
	public Cliente(UUID idCliente, String nomeCompleto, String nomeUsuario, String email, Integer cpf,
			Date dataNascimento, String endereco, Integer telefone) {
		super();
		this.idCliente = idCliente;
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	//Getters e Setters
	
	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
}



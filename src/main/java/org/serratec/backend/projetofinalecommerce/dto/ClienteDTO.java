package org.serratec.backend.projetofinalecommerce.dto;

import java.sql.Date;


public class ClienteDTO {
	
	private Integer idCliente;
	private String nomeCliente;
	private String loginCliente;
	private String senhaCliente;
	private String emailCliente;
	private Integer cpfCliente;
	private Date dataNasciCliente;
	private String enderecoCliente;
	private Integer telefoneCliente;


	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getLoginCliente() {
		return loginCliente;
	}

	public void setLoginCliente(String loginCliente) {
		this.loginCliente = loginCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public Integer getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(Integer cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Date getDataNasciCliente() {
		return dataNasciCliente;
	}

	public void setDataNasciCliente(Date dataNasciCliente) {
		this.dataNasciCliente = dataNasciCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public Integer getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(Integer telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}
}

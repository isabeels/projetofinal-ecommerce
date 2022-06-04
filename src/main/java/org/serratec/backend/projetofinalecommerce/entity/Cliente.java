package org.serratec.backend.projetofinalecommerce.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_cd_id")
	private Integer idCliente;

	@NotNull
	@Column(name = "cliente_tx_nome")
	private String nomeCliente;

	@NotNull
	@Column(name = "cliente_tx_login")
	private String loginCliente;

	@NotNull
	@Email
	@Column(name = "cliente_tx_email")
	private String emailCliente;

	@NotNull
	@Column(name = "cliente_tx_senha")
	private String senhaCliente;

	@NotNull
	@Size(min = 11, max = 11)
	@Column(name = "cliente_nu_cpf")
	private String cpfCliente;

	@NotNull
	@Column(name = "cliente_dt_nascimento")
	private Date dataNasciCliente;

	@NotNull
	@Column(name = "cliente_tx_endereco")
	private String enderecoCliente;

	@NotNull
	@Column(name = "cliente_tx_telefone")
	private String telefoneCliente;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listaPedido;

	// Construtores

	public Cliente() {
	}

	public Cliente(Integer idCliente, String nomeCliente, String loginCliente, String emailCliente, String cpfCliente,
			Date dataNasciCliente, String enderecoCliente, String telefoneCliente) {
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
		this.loginCliente = loginCliente;
		this.emailCliente = emailCliente;
		this.cpfCliente = cpfCliente;
		this.dataNasciCliente = dataNasciCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefoneCliente = telefoneCliente;
	}

	public String getSenhaCliente() {
		return senhaCliente;
	}

	public void setSenhaCliente(String senhaCliente) {
		this.senhaCliente = senhaCliente;
	}

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

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
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

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public List<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void setListaPedido(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	// Getters e Setters

}

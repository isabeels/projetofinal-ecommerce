package org.serratec.backend.projetofinalecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "funcionario_cd_id")
	private Integer idFuncionario;

	@NotBlank
	@Column(name = "funcionario_tx_nomeCompleto")
	private String nomeCompleto;

	@NotBlank
	@Size(min = 11, max = 11)
	@Column(name = "funcionario_tx_cpf")
	private Integer cpf;

	public Funcionario() {

	}

	public Funcionario(Integer idFuncionario, String nomeCompleto, Integer cpf) {
		this.idFuncionario = idFuncionario;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

}

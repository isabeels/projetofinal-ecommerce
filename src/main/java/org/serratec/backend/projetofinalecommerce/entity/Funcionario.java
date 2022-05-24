package org.serratec.backend.projetofinalecommerce.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_cd_id")
	private Integer idFuncionario;

	@Column(name = "funcionario_tx_nomeCompleto")
	private String nomeCompleto;

	@Column(name = "funcionario_tx_cpf")
	private Integer cpf;
	
	public Funcionario() {
		
	}

	public Funcionario(Integer idFuncionario, String nomeCompleto, Integer cpf) {
		super();
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


package org.serratec.backend.projetofinalecommerce.entity;

import java.util.UUID;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "funcionario_cd_id")
	private UUID idFuncionario;

	@Column(name = "funcionario_tx_nomeCompleto")
	private String nomeCompleto;

	@Column(name = "funcionario_tx_cpf")
	private Integer cpf;
	
	public Funcionario() {
		
	}

	public Funcionario(UUID idFuncionario, String nomeCompleto, Integer cpf) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
	}

	public UUID getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(UUID idFuncionario) {
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


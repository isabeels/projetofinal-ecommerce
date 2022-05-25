package org.serratec.backend.projetofinalecommerce.dto;

import java.util.UUID;


public class FuncionarioDTO {

	private UUID idFuncionario;
	private String nomeCompleto;
	private Integer cpf;
	
	
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

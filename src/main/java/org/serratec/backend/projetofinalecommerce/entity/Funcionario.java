package org.serratec.backend.projetofinalecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "funcionario_cd_id")
	private Integer idFuncionario;

	@NotBlank
	@Column(name = "funcionario_tx_nome")
	private String nomeFuncionario;

	@NotBlank
	@Column(name = "funcionario_nu_cpf")
	@Size(min = 11, max = 11)
	private Integer cpfFuncionario;

	@OneToMany(mappedBy = "funcionario")
	private List<Produto> listaProdutos;

	public Funcionario() {

	}

	public Funcionario(Integer idFuncionario, @NotBlank String nomeFuncionario, @NotBlank Integer cpfFuncionario) {
		super();
		this.idFuncionario = idFuncionario;
		this.nomeFuncionario = nomeFuncionario;
		this.cpfFuncionario = cpfFuncionario;
	}

	public Integer getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Integer idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public Integer getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(Integer cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

}

package org.serratec.backend.projetofinalecommerce.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID idProduto;
	
	@Column (name = "produto_tx_nome")
	private String nomeProduto;
	
	@Column (name = "produto_tx_descricao" )
	private String descricaoProduto;
	
	@Column (name = "produto_nu_valor")
	private Double valorUnitarioProduto;
	
	@Column (name = "produto_dt_validade")
	private LocalDate dataValidadeProduto;
	
	@Column (name = "produto_nu_estoque")
	private Integer estoqueProduto;
	
	public Produto() {}

	
	public Produto(UUID idProduto, String nomeProduto, String descricaoProduto, Double valorUnitarioProduto,
			LocalDate dataValidadeProduto, Integer estoqueProduto) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitarioProduto = valorUnitarioProduto;
		this.dataValidadeProduto = dataValidadeProduto;
		this.estoqueProduto = estoqueProduto;
	}

	public UUID getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(UUID idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public LocalDate getDataValidadeProduto() {
		return dataValidadeProduto;
	}

	public void setDataValidadeProduto(LocalDate dataValidadeProduto) {
		this.dataValidadeProduto = dataValidadeProduto;
	}

	public Integer getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(Integer estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

}

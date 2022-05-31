package org.serratec.backend.projetofinalecommerce.dto;

import java.time.LocalDate;

public class ProdutoDTO {

	private String nomeProduto;
	private String descricaoProduto;
	private Double valorUnitarioProduto;
	private LocalDate dataValidadeProduto;
	private Integer estoqueProduto;

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

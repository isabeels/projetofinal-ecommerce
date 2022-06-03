package org.serratec.backend.projetofinalecommerce.dto;

public class ProdutoPedidoDTO {

	private Double valorUnitario;
	private Integer quantidadeProduto;
	private Integer idProduto;
	
	public ProdutoPedidoDTO() {}
	
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	public Integer getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}
	
}

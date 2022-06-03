package org.serratec.backend.projetofinalecommerce.dto;

import java.time.LocalDateTime;

public class PedidoDTO {

	private Integer idPedido;
	private LocalDateTime dataPedido;
	private Double valorTotalPedido;
	private Integer idCliente;
	private Integer idPProduto;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Integer getIdPProduto() {
		return idPProduto;
	}

	public void setIdPProduto(Integer idPProduto) {
		this.idPProduto = idPProduto;
	}
	

}

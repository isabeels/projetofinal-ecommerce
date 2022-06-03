package org.serratec.backend.projetofinalecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoDTO {

	private Integer idPedido;
	private LocalDateTime dataPedido;
	private String operacao;
	private Integer pedidoNotaFiscal;
	private Integer idCliente;
	private List<ProdutoPedidoDTO> listaProdutoPedido;
	
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
	
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Integer getPedidoNotaFiscal() {
		return pedidoNotaFiscal;
	}
	public void setPedidoNotaFiscal(Integer pedidoNotaFiscal) {
		this.pedidoNotaFiscal = pedidoNotaFiscal;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public List<ProdutoPedidoDTO> getListaProdutoPedido() {
		return listaProdutoPedido;
	}
	public void setListaProdutoPedido(List<ProdutoPedidoDTO> listaProdutoPedido) {
		this.listaProdutoPedido = listaProdutoPedido;
	}

}

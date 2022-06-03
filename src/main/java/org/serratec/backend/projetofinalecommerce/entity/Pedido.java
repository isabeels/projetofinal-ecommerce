package org.serratec.backend.projetofinalecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "pedido")
public class Pedido {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedido_cd_id")
	private Integer idPedido;

	@NotBlank
	@Column(name = "pedido_dt_compra")
	private LocalDateTime dataPedido;

	@NotBlank
	@Column(name = "pedido_nu_valor")
	private Double valorUnitarioProduto;
	
	@NotBlank
	@Column(name = "pedido_nu_quantidade")
	private Integer quantidadeProduto;
	
	@NotBlank
	@Column(name = "pedido_tx_operacao")
	private String operacao;
	
	@NotBlank
	@Column(name = "pedido_nu_nota_fiscal")
	private Integer pedidoNotaFiscal;

	
	@OneToOne
	@JoinColumn(name = "idCliente", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "idProduto", referencedColumnName = "produto_cd_id")
	@JsonIgnore
	private Produto produto;

	public Pedido() {
	}

	public Pedido(Integer idPedido, @NotBlank LocalDateTime dataPedido, @NotBlank Double valorUnitarioProduto,
			@NotBlank Integer quantidadeProduto, @NotBlank String operacao, @NotBlank Integer pedidoNotaFiscal,
			Cliente cliente, Produto produto) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorUnitarioProduto = valorUnitarioProduto;
		this.quantidadeProduto = quantidadeProduto;
		this.operacao = operacao;
		this.pedidoNotaFiscal = pedidoNotaFiscal;
		this.cliente = cliente;
		this.produto = produto;
	}

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

	public Double getValorUnitarioProduto() {
		return valorUnitarioProduto;
	}

	public void setValorUnitarioProduto(Double valorUnitarioProduto) {
		this.valorUnitarioProduto = valorUnitarioProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}

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
	private Double valorTotalPedido;

	@OneToOne
	@JoinColumn(name = "idCliente", referencedColumnName = "cliente_cd_id")
	@JsonIgnore
	private Cliente cliente;

	@JoinColumn(name = "idProduto", referencedColumnName = "produto_cd_id")
	@JsonIgnore
	private List<Produto> listaProduto;

	public Pedido() {
	}

	public Pedido(Integer idPedido, @NotBlank LocalDateTime dataPedido, @NotBlank Double valorTotalPedido) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.valorTotalPedido = valorTotalPedido;
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

	public Double getValorTotalPedido() {
		return valorTotalPedido;
	}

	public void setValorTotalPedido(Double valorTotalPedido) {
		this.valorTotalPedido = valorTotalPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

}

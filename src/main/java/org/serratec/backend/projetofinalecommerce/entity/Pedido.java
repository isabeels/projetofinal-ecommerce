package org.serratec.backend.projetofinalecommerce.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "pedido")
public class Pedido {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

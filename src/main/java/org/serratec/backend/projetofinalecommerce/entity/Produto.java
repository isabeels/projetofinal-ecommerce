package org.serratec.backend.projetofinalecommerce.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "produto_cd_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;

	@NotBlank
	@Column(name = "produto_tx_nome")
	private String nomeProduto;

	@NotBlank
	@Column(name = "produto_tx_descricao")
	private String descricaoProduto;

	@NotBlank
	@Column(name = "produto_nu_valor")
	private Double valorUnitario;

	@NotBlank
	@Column(name = "produto_dt_fabricacao")
	private LocalDate dataFabricacao;

	@NotBlank
	@Column(name = "produto_nu_estoque")
	private Integer qtdEstoque;

	/* verificar entidade relacionamento desta tabela com pedido */

	@ManyToOne
	private Pedido pedido;

	@OneToOne
	@JoinColumn(name = "idCategoria", referencedColumnName = "categoria_cd_id")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "idFuncionario", referencedColumnName = "funcionario_cd_id")
	private Funcionario funcionario;

	public Produto() {
	}

	public Produto(Integer idProduto, @NotBlank String nomeProduto, @NotBlank String descricaoProduto,
			@NotBlank Double valorUnitario, @NotBlank LocalDate dataFabricacao, @NotBlank Integer qtdEstoque) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.descricaoProduto = descricaoProduto;
		this.valorUnitario = valorUnitario;
		this.dataFabricacao = dataFabricacao;
		this.qtdEstoque = qtdEstoque;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
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

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}

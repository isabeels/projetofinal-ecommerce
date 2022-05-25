package org.serratec.backend.projetofinalecommerce.dto;

public class CategoriaDTO {
	/* @NotBlank */
	private String nomeCategoria;
	/* @NotBlank */
	private String descricaoCategoria;

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

}

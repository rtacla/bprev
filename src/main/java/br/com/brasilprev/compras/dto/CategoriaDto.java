package br.com.brasilprev.compras.dto;

public class CategoriaDto {
	
	private Long idCategoria;
	
	private String categoria;
	
	public CategoriaDto() {}

	public CategoriaDto(Long idCategoria, String categoria) {
		this.idCategoria = idCategoria;
		this.categoria = categoria;
	}


	public Long getIdCategoria() {
		return idCategoria;
	}


	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	

}

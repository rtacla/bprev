package br.com.brasilprev.compras.service;

import java.util.List;

import br.com.brasilprev.compras.dto.CategoriaDto;
import br.com.brasilprev.compras.entity.Categoria;

public interface CategoriaService {
	public List<Categoria> getCategorias();
	public CategoriaDto findById(Long id);
	public CategoriaDto update(CategoriaDto categoria);
	public void delete(Long id);
	public CategoriaDto insert(CategoriaDto categoria);

}

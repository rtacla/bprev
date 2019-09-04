package br.com.brasilprev.compras.service;

import java.util.List;

import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Produto;

public interface ProdutoService {
	public List<ProdutoDto> getProdutos();
	public ProdutoDto findById(Long id);
	public void update(ProdutoDto cliente);
	public void delete(Long id);
	public ProdutoDto insert(ProdutoDto cliente);

}

package br.com.brasilprev.compras.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Pedido;
import br.com.brasilprev.compras.entity.Produto;
import br.com.brasilprev.compras.repository.ProdutoRepository;
import br.com.brasilprev.compras.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public List<ProdutoDto> getProdutos() {
		List<Produto> produtos = produtoRepository.findAll();
		ArrayList<ProdutoDto> produtoDtos = new ArrayList<>();
		for(Produto produto : produtos) {
			produtoDtos.add(modelMapper.map(produto, ProdutoDto.class));
		}
		return produtoDtos;
	}


	@Override
	public ProdutoDto findById(Long id) {
		Produto produto = produtoRepository.findById(id).orElse(null);
		return modelMapper.map(produto, ProdutoDto.class);
	}
	
	@Override
	public void update(ProdutoDto produto) {
		Produto produtoEntity = modelMapper.map(produto, Produto.class);
		produtoRepository.save(produtoEntity);
	}


	@Override
	public void delete(Long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public ProdutoDto insert(ProdutoDto produto) {
		return modelMapper.map(produtoRepository.save(modelMapper.map(produto, Produto.class)), ProdutoDto.class);
	}

}

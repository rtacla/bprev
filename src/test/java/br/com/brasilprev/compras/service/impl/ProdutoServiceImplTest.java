package br.com.brasilprev.compras.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import br.com.brasilprev.compras.dto.CategoriaDto;
import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Categoria;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.entity.Produto;
import br.com.brasilprev.compras.repository.ProdutoRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceImplTest {

	@InjectMocks
	private ProdutoServiceImpl produtoServiceImpl;

	@Mock
	private ProdutoRepository produtoRepository;
	
	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {

		Mockito.when(produtoRepository.findById(Mockito.anyLong())).thenReturn(mockProduto());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockProdutoDto());
		ProdutoDto produto = produtoServiceImpl.findById(1L);
		Assert.assertEquals(produto.getIdProduto().longValue(), 1L);
	}
	
	@Test
	public void testDelete() {
		Mockito.doNothing().when(produtoRepository).deleteById(Mockito.anyLong());
		produtoServiceImpl.delete(1L);
	}
	
	
	
	@Test
	public void testList() {
		Mockito.when(produtoRepository.findAll()).thenReturn(mockListProdutos());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockProdutoDto());
		List<ProdutoDto> produtoDtos = produtoServiceImpl.getProdutos();
		Assert.assertEquals(produtoDtos.get(0).getIdProduto().longValue(), 1L);
	}
	
	
	private List<Produto> mockListProdutos() {
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto(1L, "XXX"));
		produtos.add(new Produto(2L, "XXX"));
		return produtos;
	}



	private ProdutoDto mockProdutoDto() {
		ProdutoDto produto = new ProdutoDto(1L, "TESTE");
		produto.setIdProduto(1L);
		produto.setDescricao("XXX");
		produto.setCategoria(new CategoriaDto(1L, "TESTE"));
		produto.setFoto("http:\\www.google.com.br");
		produto.setPreco(new BigDecimal(123));
		produto.setQuantidade(12);
		return produto;
	}

	public Optional<Produto> mockProduto() {
		Produto produto = new Produto();
		produto.setProduto("TESTE");
		produto.setIdProduto(1L);
		produto.setDescricao("XXX");
		produto.setCategoria(new Categoria());
		produto.setFoto("http:\\www.google.com.br");
		produto.setPreco(new BigDecimal(123));
		produto.setQuantidade(12);

		return Optional.of(produto);
	}

}

package br.com.brasilprev.compras.service.impl;

import java.math.BigDecimal;
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
import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Categoria;
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

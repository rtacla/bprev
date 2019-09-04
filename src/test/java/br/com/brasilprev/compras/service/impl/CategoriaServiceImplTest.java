package br.com.brasilprev.compras.service.impl;

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
import br.com.brasilprev.compras.entity.Categoria;
import br.com.brasilprev.compras.repository.CategoriaRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceImplTest {

	@InjectMocks
	private CategoriaServiceImpl categoriaServiceImpl;

	@Mock
	private CategoriaRepository categoriaRepository;
	
	@Mock
	ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {
		Mockito.when(categoriaRepository.findById(Mockito.anyLong())).thenReturn(mockCategoria());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockCategoriaDto());
		CategoriaDto categoria = categoriaServiceImpl.findById(1L);
		Assert.assertEquals(categoria.getIdCategoria().longValue(), 1L);
	}
	
	@Test
	public void testUpdate() {
		Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(mockCategoriaSingle());
		Mockito.when(categoriaRepository.save(Mockito.any())).thenReturn(mockCategoria());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockCategoriaDto());
		CategoriaDto categoria = categoriaServiceImpl.update(mockCategoriaDto());
		Assert.assertEquals(categoria.getIdCategoria().longValue(), mockCategoriaDto().getIdCategoria().longValue());
	}


	private CategoriaDto mockCategoriaDto() {
		return new CategoriaDto(1L, "TESTE");
	}
	
	public Categoria mockCategoriaSingle() {
		Categoria categoria = new Categoria();
		categoria.setCategoria("TESTE");
		categoria.setIdCategoria(1L);
		return categoria;
	}


	public Optional<Categoria> mockCategoria() {
		Categoria categoria = new Categoria();
		categoria.setCategoria("TESTE");
		categoria.setIdCategoria(1L);
		return Optional.of(categoria);
	}

}

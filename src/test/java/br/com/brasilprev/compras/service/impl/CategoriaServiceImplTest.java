package br.com.brasilprev.compras.service.impl;

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
import br.com.brasilprev.compras.entity.Categoria;
import br.com.brasilprev.compras.repository.CategoriaRepository;

@RunWith(MockitoJUnitRunner.class)
public class CategoriaServiceImplTest {

	@InjectMocks
	private CategoriaServiceImpl categoriaServiceImpl;

	@Mock
	private CategoriaRepository categoriaRepository;
	
	@Mock
	private ModelMapper modelMapper;

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
	public void testDelete() {
		Mockito.doNothing().when(categoriaRepository).deleteById(Mockito.anyLong());
		categoriaServiceImpl.delete(1L);
	}
	
	@Test
	public void testList() {
		Mockito.when(categoriaRepository.findAll()).thenReturn(mockListCategoria());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockCategoriaDto());
		List<CategoriaDto> categoriaDtos = categoriaServiceImpl.getCategorias();
		Assert.assertEquals(categoriaDtos.get(0).getIdCategoria().longValue(), 1L);
	}
	
	
	private List<Categoria> mockListCategoria() {
		ArrayList<Categoria> categorias = new ArrayList<>();
		categorias.add(new Categoria(1L, "TESTE"));
		categorias.add(new Categoria(2L, "TESTE"));
		return categorias;
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

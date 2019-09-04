package br.com.brasilprev.compras.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.compras.dto.CategoriaDto;
import br.com.brasilprev.compras.entity.Categoria;
import br.com.brasilprev.compras.repository.CategoriaRepository;
import br.com.brasilprev.compras.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository	;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public List<CategoriaDto> getCategorias() {
		List<Categoria> categorias = categoriaRepository.findAll();
		ArrayList<CategoriaDto> categoriaDtos = new ArrayList<>();
		for(Categoria categoria : categorias) {
			categoriaDtos.add(modelMapper.map(categoria, CategoriaDto.class));
		}
		return categoriaDtos;
		
	}

	@Override
	public CategoriaDto findById(Long id) {
		Optional<Categoria> optCategoria = categoriaRepository.findById(id);
		Categoria categoria = optCategoria.get();
		return modelMapper.map(categoria, CategoriaDto.class);
	}
	

	@Override
	public CategoriaDto update(CategoriaDto categoriaDto) {
		Categoria categoriaEntity = modelMapper.map(categoriaDto, Categoria.class);
		Categoria save = categoriaRepository.save(categoriaEntity);
		return modelMapper.map(save, CategoriaDto.class);
	}


	@Override
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}

	@Override
	public CategoriaDto insert(CategoriaDto categoriaDto) {
		Categoria categoria = modelMapper.map(categoriaDto, Categoria.class);
		categoria = categoriaRepository.save(categoria);
		return modelMapper.map(categoria, CategoriaDto.class);
		
	}

}

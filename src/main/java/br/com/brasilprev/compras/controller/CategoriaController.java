package br.com.brasilprev.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasilprev.compras.dto.CategoriaDto;
import br.com.brasilprev.compras.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<CategoriaDto>> getCategorias() {
		List<CategoriaDto> categorias = categoriaService.getCategorias();
		return new ResponseEntity<List<CategoriaDto>>(categorias, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public CategoriaDto getCategoria(@PathVariable Long id) {
		return categoriaService.findById(id);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Object> updateCategoria(@RequestBody CategoriaDto categoria) {
		categoriaService.update(categoria);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCategoria(@PathVariable Long id) {
		categoriaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public CategoriaDto insertCategoria(@RequestBody CategoriaDto categoria) {
		return categoriaService.insert(categoria);
	}

	
	
}

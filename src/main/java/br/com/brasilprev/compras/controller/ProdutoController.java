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

import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Produto;
import br.com.brasilprev.compras.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<ProdutoDto>> getProdutos() {
		List<ProdutoDto> produtos = produtoService.getProdutos();
		return new ResponseEntity<List<ProdutoDto>>(produtos, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ProdutoDto getProduto(@PathVariable Long id) {
		return produtoService.findById(id);
	}
	
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Object> updateProduto(@RequestBody ProdutoDto produto) {
		produtoService.update(produto);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteProduto(@PathVariable Long id) {
		produtoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ProdutoDto insertProduto(@RequestBody ProdutoDto produto) {
		return produtoService.insert(produto);
	}
}

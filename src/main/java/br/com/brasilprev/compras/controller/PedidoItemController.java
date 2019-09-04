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

import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.entity.PedidoItem;
import br.com.brasilprev.compras.service.PedidoItemService;

@RestController
@RequestMapping("/api/pedidoItens")
public class PedidoItemController {
	
	@Autowired
	private PedidoItemService pedidoItemService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<PedidoItem>> getPedidoItems() {
		List<PedidoItem> pedidoItens = pedidoItemService.getPedidoItens();
		return new ResponseEntity<List<PedidoItem>>(pedidoItens, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public PedidoItemDto getPedidoItem(@PathVariable Long id) {
		return pedidoItemService.findById(id);
	}
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Object> updatePedidoItem(@RequestBody PedidoItemDto pedidoItem) {
		pedidoItemService.update(pedidoItem);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deletePedidoItem(@PathVariable Long id) {
		pedidoItemService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public PedidoItemDto insertPedidoItem(@RequestBody PedidoItemDto pedidoItem) {
		return pedidoItemService.insert(pedidoItem);
	}
}

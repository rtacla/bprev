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
import br.com.brasilprev.compras.entity.Pedido;
import br.com.brasilprev.compras.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<PedidoDto>> getPedidos() {
		List<PedidoDto> pedidos = pedidoService.getPedidos();
		return new ResponseEntity<List<PedidoDto>>(pedidos, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public PedidoDto getPedido(@PathVariable Long id) {
		return pedidoService.findById(id);
	}
	
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Object> updatePedido(@RequestBody PedidoDto pedido) {
		pedidoService.update(pedido);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deletePedido(@PathVariable Long id) {
		pedidoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public PedidoDto insertPedido(@RequestBody PedidoDto pedido) {
		return pedidoService.insert(pedido);
	}
}

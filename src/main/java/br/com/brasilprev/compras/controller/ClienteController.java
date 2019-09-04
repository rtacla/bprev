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

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(method= RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>> getClientes() {
		List<ClienteDto> clientes = clienteService.getClientes();
		return new ResponseEntity<List<ClienteDto>>(clientes, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ClienteDto getCliente(@PathVariable Long id) {
		return clienteService.findById(id);
	}
	
	
	@RequestMapping(method= RequestMethod.PUT)
	public ResponseEntity<Object> updateCliente(@RequestBody ClienteDto cliente) {
		clienteService.update(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Object> deleteCliente(@PathVariable Long id) {
		clienteService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public ClienteDto insertCliente(@RequestBody ClienteDto cliente) {
		return clienteService.insert(cliente);
	}
}

package br.com.brasilprev.compras.service;

import java.util.List;

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.entity.Cliente;

public interface ClienteService {
	public List<ClienteDto> getClientes();
	public ClienteDto findById(Long id);
	public void update(ClienteDto cliente);
	public void delete(Long id);
	public ClienteDto insert(ClienteDto cliente);

}

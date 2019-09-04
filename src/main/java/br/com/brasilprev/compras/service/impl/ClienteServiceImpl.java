package br.com.brasilprev.compras.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.repository.ClienteRepository;
import br.com.brasilprev.compras.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository	;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public List<ClienteDto> getClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		ArrayList<ClienteDto> clienteDtos = new ArrayList<>();
		for(Cliente cliente : clientes) {
			clienteDtos.add(modelMapper.map(cliente, ClienteDto.class));
		}
		return clienteDtos;
	}


	@Override
	public ClienteDto findById(Long id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		return modelMapper.map(cliente, ClienteDto.class);
	}
	
	@Override
	public void update(ClienteDto cliente) {
		Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
		clienteRepository.save(clienteEntity);
	}


	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public ClienteDto insert(ClienteDto cliente) {
		return modelMapper.map(clienteRepository.save(modelMapper.map(cliente, Cliente.class)), ClienteDto.class);
	}

}

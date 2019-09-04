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
import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {

	@InjectMocks
	private ClienteServiceImpl clienteServiceImpl;

	@Mock
	private ClienteRepository clienteRepository;
	
	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {

		Mockito.when(clienteRepository.findById(Mockito.anyLong())).thenReturn(mockCliente());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockClienteDto());
		ClienteDto Cliente = clienteServiceImpl.findById(1L);
		Assert.assertEquals(Cliente.getIdCliente().longValue(), 1L);
	}
	
	
	@Test
	public void testDelete() {
		Mockito.doNothing().when(clienteRepository).deleteById(Mockito.anyLong());
		clienteServiceImpl.delete(1L);
	}
	
	@Test
	public void testList() {
		Mockito.when(clienteRepository.findAll()).thenReturn(mockListClientes());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockClienteDto());
		List<ClienteDto> clienteDtos = clienteServiceImpl.getClientes();
		Assert.assertEquals(clienteDtos.get(0).getIdCliente().longValue(), 1L);
	}
	
	
	private List<Cliente> mockListClientes() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente(1L));
		clientes.add(new Cliente(2L));
		return clientes;
	}




	private ClienteDto mockClienteDto() {
		ClienteDto cliente = new ClienteDto(1L, "JOSE");
		cliente.setIdCliente(1L);
		cliente.setNome("JOSE");
		cliente.setBairro("XXX");
		cliente.setCidade("SAO PAULO");
		cliente.setCep("00000000");
		cliente.setEmail("teste@teste.com");
		cliente.setEstado("SP");
		return cliente;
	}

	public Optional<Cliente> mockCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome("TESTE");
		cliente.setBairro("XXX");
		cliente.setCidade("SAO PAULO");
		cliente.setCep("00000000");
		cliente.setEmail("teste@teste.com");
		cliente.setEstado("SP");
		return Optional.of(cliente);
	}

}

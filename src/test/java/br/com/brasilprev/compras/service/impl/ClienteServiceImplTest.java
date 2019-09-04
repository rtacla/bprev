package br.com.brasilprev.compras.service.impl;

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

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.repository.ClienteRepository;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceImplTest {

	@InjectMocks
	private ClienteServiceImpl ClienteServiceImpl;

	@Mock
	private ClienteRepository ClienteRepository;
	
	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {

		Mockito.when(ClienteRepository.findById(Mockito.anyLong())).thenReturn(mockCliente());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockClienteDto());
		ClienteDto Cliente = ClienteServiceImpl.findById(1L);
		Assert.assertEquals(Cliente.getIdCliente().longValue(), 1L);
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

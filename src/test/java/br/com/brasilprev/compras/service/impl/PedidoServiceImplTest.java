package br.com.brasilprev.compras.service.impl;

import java.time.LocalDateTime;
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

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.entity.Cliente;
import br.com.brasilprev.compras.entity.Pedido;
import br.com.brasilprev.compras.entity.PedidoItem;
import br.com.brasilprev.compras.repository.PedidoRepository;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceImplTest {

	@InjectMocks
	private PedidoServiceImpl pedidoServiceImpl;

	@Mock
	private PedidoRepository pedidoRepository;
	
	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {

		Mockito.when(pedidoRepository.findById(Mockito.anyLong())).thenReturn(mockPedido());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockPedidoDto());
		PedidoDto Pedido = pedidoServiceImpl.findById(1L);
		Assert.assertEquals(Pedido.getIdPedido().longValue(), 1L);
	}
	
	@Test
	public void testDelete() {
		Mockito.doNothing().when(pedidoRepository).deleteById(Mockito.anyLong());
		pedidoServiceImpl.delete(1L);
	}
	
	@Test
	public void testList() {
		Mockito.when(pedidoRepository.findAll()).thenReturn(mockListPedidoItens());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockPedidoDto());
		List<PedidoDto> pedidoDtos = pedidoServiceImpl.getPedidos();
		Assert.assertEquals(pedidoDtos.get(0).getIdPedido().longValue(), 1L);
	}
	
	
	private List<Pedido> mockListPedidoItens() {
		ArrayList<Pedido> pedidos = new ArrayList<>();
		pedidos.add(new Pedido(1L));
		pedidos.add(new Pedido(2L));
		return pedidos;
	}
	


	private PedidoDto mockPedidoDto() {
		PedidoDto pedido = new PedidoDto();
		pedido.setIdPedido(1L);
		pedido.setData(LocalDateTime.now());
		pedido.setSessao("XXX");
		pedido.setStatus("XXXX");
		pedido.setCliente(new ClienteDto(1L, "JOSE"));
		return pedido;
	}

	public Optional<Pedido> mockPedido() {
		Pedido pedido = new Pedido();
		pedido.setIdPedido(1L);
		pedido.setData(LocalDateTime.now());
		pedido.setSessao("XXX");
		pedido.setStatus("XXXX");
		pedido.setCliente(new Cliente());
		return Optional.of(pedido);
	}

}

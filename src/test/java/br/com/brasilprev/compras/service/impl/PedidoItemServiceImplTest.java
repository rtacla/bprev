package br.com.brasilprev.compras.service.impl;

import java.math.BigDecimal;
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

import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.dto.ProdutoDto;
import br.com.brasilprev.compras.entity.Pedido;
import br.com.brasilprev.compras.entity.PedidoItem;
import br.com.brasilprev.compras.entity.Produto;
import br.com.brasilprev.compras.repository.PedidoItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class PedidoItemServiceImplTest {

	@InjectMocks
	private PedidoItemServiceImpl PedidoItemServiceImpl;

	@Mock
	private PedidoItemRepository PedidoItemRepository;
	
	@Mock
	private ModelMapper modelMapper;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindById() {

		Mockito.when(PedidoItemRepository.findById(Mockito.anyLong())).thenReturn(mockPedidoItem());
		Mockito.when(modelMapper.map(Mockito.any(),  Mockito.any())).thenReturn(mockPedidoItemDto());
		PedidoItemDto PedidoItem = PedidoItemServiceImpl.findById(1L);
		Assert.assertEquals(PedidoItem.getIdItem().longValue(), 1L);
	}

	private PedidoItemDto mockPedidoItemDto() {
		PedidoItemDto pedidoItem = new PedidoItemDto();
		pedidoItem.setIdItem(1L);
		pedidoItem.setPedido(new PedidoDto());
		pedidoItem.setProduto(new ProdutoDto(1L, "TESTE"));
		pedidoItem.setQuantidade(12);
		pedidoItem.setSubTotal(new BigDecimal(24));
		pedidoItem.setValor(new BigDecimal(24));
		return pedidoItem;
	}

	public Optional<PedidoItem> mockPedidoItem() {
		PedidoItem pedidoItem = new PedidoItem();
		pedidoItem.setIdItem(1L);
		pedidoItem.setPedido(new Pedido());
		pedidoItem.setProduto(new Produto());
		pedidoItem.setQuantidade(12);
		pedidoItem.setSubTotal(new BigDecimal(24));
		pedidoItem.setValor(new BigDecimal(24));
		return Optional.of(pedidoItem);
	}

}

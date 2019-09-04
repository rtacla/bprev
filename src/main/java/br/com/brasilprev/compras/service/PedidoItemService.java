package br.com.brasilprev.compras.service;

import java.util.List;

import br.com.brasilprev.compras.dto.ClienteDto;
import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.entity.PedidoItem;

public interface PedidoItemService {
	public List<PedidoItemDto> getPedidoItens();
	public PedidoItemDto findById(Long id);
	public void update(PedidoItemDto cliente);
	public void delete(Long id);
	public PedidoItemDto insert(PedidoItemDto cliente);

	
}

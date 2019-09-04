package br.com.brasilprev.compras.service;

import java.util.List;

import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.entity.Pedido;

public interface PedidoService {
	public List<PedidoDto> getPedidos();
	public PedidoDto findById(Long id);
	public void update(PedidoDto cliente);
	public void delete(Long id);
	public PedidoDto insert(PedidoDto cliente);


}

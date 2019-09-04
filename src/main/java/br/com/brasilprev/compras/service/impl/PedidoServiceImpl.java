package br.com.brasilprev.compras.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.compras.dto.PedidoDto;
import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.entity.Pedido;
import br.com.brasilprev.compras.entity.PedidoItem;
import br.com.brasilprev.compras.repository.PedidoRepository;
import br.com.brasilprev.compras.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository	;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public List<PedidoDto> getPedidos() {
		List<Pedido> pedidoItems = pedidoRepository.findAll();
		ArrayList<PedidoDto> pedidoDtos = new ArrayList<>();
		for(Pedido pedido : pedidoItems) {
			pedidoDtos.add(modelMapper.map(pedido, PedidoDto.class));
		}
		return pedidoDtos;

	}

	@Override
	public PedidoDto findById(Long id) {
		Pedido pedido = pedidoRepository.findById(id).orElse(null);
		return modelMapper.map(pedido, PedidoDto.class);
	}
	
	
	@Override
	public void update(PedidoDto pedido) {
		Pedido pedidoEntity = modelMapper.map(pedido, Pedido.class);
		pedidoRepository.save(pedidoEntity);
	}


	@Override
	public void delete(Long id) {
		pedidoRepository.deleteById(id);
	}

	@Override
	public PedidoDto insert(PedidoDto pedido) {
		return modelMapper.map(pedidoRepository.save(modelMapper.map(pedido, Pedido.class)), PedidoDto.class);
	}
}

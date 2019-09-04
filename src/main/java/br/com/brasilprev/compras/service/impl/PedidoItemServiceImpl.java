package br.com.brasilprev.compras.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasilprev.compras.dto.PedidoItemDto;
import br.com.brasilprev.compras.entity.PedidoItem;
import br.com.brasilprev.compras.repository.PedidoItemRepository;
import br.com.brasilprev.compras.service.PedidoItemService;

@Service
public class PedidoItemServiceImpl implements PedidoItemService {
	
	@Autowired
	private PedidoItemRepository pedidoItemRepository	;
	
	@Autowired
	private ModelMapper modelMapper;

	
	public List<PedidoItem> getPedidoItens() {
		return pedidoItemRepository.findAll();
	}


	@Override
	public PedidoItemDto findById(Long id) {
		PedidoItem pedidoItem = pedidoItemRepository.findById(id).orElse(null);
		return modelMapper.map(pedidoItem,  PedidoItemDto.class);
	}
	
	@Override
	public void update(PedidoItemDto pedidoItem) {
		PedidoItem pedidoItemEntity = modelMapper.map(pedidoItem, PedidoItem.class);
		pedidoItemRepository.save(pedidoItemEntity);
	}


	@Override
	public void delete(Long id) {
		pedidoItemRepository.deleteById(id);
	}

	@Override
	public PedidoItemDto insert(PedidoItemDto pedidoItem) {
		return modelMapper.map(pedidoItemRepository.save(modelMapper.map(pedidoItem, PedidoItem.class)), PedidoItemDto.class);
	}
	
	

}

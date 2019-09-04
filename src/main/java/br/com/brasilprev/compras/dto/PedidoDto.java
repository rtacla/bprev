package br.com.brasilprev.compras.dto;

import java.time.LocalDateTime;

public class PedidoDto {
	private Long idPedido;
	
	private ClienteDto cliente;
	
	private LocalDateTime data;
	
	private String status;
	
	private String sessao;
	
	public PedidoDto() {}
	
	public PedidoDto(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSessao() {
		return sessao;
	}

	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	
}

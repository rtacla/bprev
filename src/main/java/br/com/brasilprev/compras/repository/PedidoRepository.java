package br.com.brasilprev.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilprev.compras.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {} 


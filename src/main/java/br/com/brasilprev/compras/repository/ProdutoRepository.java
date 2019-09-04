package br.com.brasilprev.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilprev.compras.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {} 


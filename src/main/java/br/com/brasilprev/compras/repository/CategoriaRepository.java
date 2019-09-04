package br.com.brasilprev.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brasilprev.compras.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {} 


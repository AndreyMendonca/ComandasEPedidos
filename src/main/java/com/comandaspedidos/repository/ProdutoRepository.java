package com.comandaspedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByAtivo(Boolean ativo);
}

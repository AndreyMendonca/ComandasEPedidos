package com.comandaspedidos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findByAtivo(Boolean ativo);
}

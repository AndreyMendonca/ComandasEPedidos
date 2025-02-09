package com.comandaspedidos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	List<Categoria> findByAtivo(Boolean ativo);
	Optional<Categoria> findByNomeAndAtivo(String nome, Boolean ativo);
	List<Categoria> findByAtivoAndNomeContainingIgnoreCase(Boolean ativo, String nome);
}

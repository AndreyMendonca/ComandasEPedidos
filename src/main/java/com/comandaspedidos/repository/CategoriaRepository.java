package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}

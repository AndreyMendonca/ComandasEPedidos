package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}

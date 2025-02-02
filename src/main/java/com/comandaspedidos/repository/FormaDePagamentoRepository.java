package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.FormaDePagamento;

public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamento,Long> {

}

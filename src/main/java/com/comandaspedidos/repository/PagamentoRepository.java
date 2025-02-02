package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}

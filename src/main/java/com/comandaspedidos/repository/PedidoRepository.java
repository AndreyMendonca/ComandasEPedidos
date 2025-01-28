package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}

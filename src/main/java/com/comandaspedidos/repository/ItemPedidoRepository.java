package com.comandaspedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.ItemPedido;
import com.comandaspedidos.models.pk.ItemPedidoPK;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK>{

}

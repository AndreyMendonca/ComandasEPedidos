package com.comandaspedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comandaspedidos.models.Pedido;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoService service;
	
	@PostMapping
	public Pedido save(@RequestBody PedidoRequestDTO pedidoDTO) {
		return service.criarPedido(pedidoDTO);
	}
	
	@GetMapping("/{id}")
	public Pedido findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
}

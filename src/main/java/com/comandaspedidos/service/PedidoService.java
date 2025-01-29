package com.comandaspedidos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.ItemPedido;
import com.comandaspedidos.models.Pedido;
import com.comandaspedidos.models.Produto;
import com.comandaspedidos.models.DTO.ItensPedidoRequestDTO;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.repository.ItemPedidoRepository;
import com.comandaspedidos.repository.PedidoRepository;
import com.comandaspedidos.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public Pedido criarPedido(PedidoRequestDTO peditoDTO) {
		Pedido novoPedido = new Pedido();
		repository.save(novoPedido);
		
		for(ItensPedidoRequestDTO itensPedidoDTO : peditoDTO.getItens()) {
			Produto produto = produtoRepository.findById(itensPedidoDTO.getIdProduto()).orElseThrow( () -> new RuntimeException("Produto não localizado"));
			ItemPedido itemPedido = new ItemPedido(
					novoPedido, produto, itensPedidoDTO.getQuantidade(), itensPedidoDTO.getObservacao());
			itemPedidoRepository.save(itemPedido);
			novoPedido.getItens().add(itemPedido);
		}
		
		return repository.save(novoPedido);
	}
	
	public Pedido adicionarItensAoPedido(PedidoRequestDTO peditoDTO, Long idPedido) {
		Pedido pedidoExistente = this.findById(idPedido);
		
		for(ItensPedidoRequestDTO itensPedidoDTO : peditoDTO.getItens()) {
			Produto produto = produtoRepository.findById(itensPedidoDTO.getIdProduto()).orElseThrow( () -> new RuntimeException("Produto não localizado"));
			
			ItemPedido itemPedido = new ItemPedido(
					pedidoExistente, produto, itensPedidoDTO.getQuantidade(), itensPedidoDTO.getObservacao());
			itemPedidoRepository.save(itemPedido);
			
			pedidoExistente.getItens().add(itemPedido);
		}
		return repository.save(pedidoExistente);
	}
	
	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Pedido nao existe"));
	}
}

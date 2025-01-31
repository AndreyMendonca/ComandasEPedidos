package com.comandaspedidos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.ItemPedido;
import com.comandaspedidos.models.Pedido;
import com.comandaspedidos.models.Produto;
import com.comandaspedidos.models.DTO.ItensPedidoRequestDTO;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.models.pk.ItemPedidoPK;
import com.comandaspedidos.repository.ItemPedidoRepository;
import com.comandaspedidos.repository.PedidoRepository;
import com.comandaspedidos.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

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
	
	@Transactional
	public Pedido adicionarItensAoPedido(PedidoRequestDTO peditoDTO, Pedido pedido) {
		
		for(ItensPedidoRequestDTO itemPedidoDTO : peditoDTO.getItens()) {
			Produto produto = produtoRepository.findById(itemPedidoDTO.getIdProduto()).orElseThrow( () -> new RuntimeException("Produto não localizado"));
			
			if(itemPedidoDTO.getQuantidade() == 0) {
				itemPedidoDTO.setQuantidade(1);
			}
			
			ItemPedido itemPedido = new ItemPedido(
					pedido, produto, itemPedidoDTO.getQuantidade(), itemPedidoDTO.getObservacao());
			
			ItemPedidoPK id = new ItemPedidoPK();
			id.setPedido(pedido);
			id.setProduto(produto);
			Optional<ItemPedido> itemPedidoExistente = itemPedidoRepository.findById(id);
			
			if(itemPedidoExistente.isPresent()) {
				itemPedidoExistente.get().setQuantidade( (itemPedidoExistente.get().getQuantidade() + itemPedidoDTO.getQuantidade()) );
				itemPedidoRepository.save(itemPedidoExistente.get());
			}else {
				itemPedidoRepository.save(itemPedido);
			}
		
			pedido.getItens().add(itemPedido);
		}
		return repository.save(pedido);
	}
	
	public Pedido findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new RuntimeException("Pedido nao existe"));
	}
}

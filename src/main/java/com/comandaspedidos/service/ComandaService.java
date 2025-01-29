package com.comandaspedidos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.Comanda;
import com.comandaspedidos.models.Pedido;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.repository.ComandaRepository;

@Service
public class ComandaService {
	@Autowired
	private ComandaRepository repository;
	
	@Autowired
	private PedidoService pedidoService;
	
	public Comanda abrirComanda(Comanda comanda) {
		Optional<Comanda> comandaExistente = repository.findByAbertaAndIdentificacao(true, comanda.getIdentificacao());
		if(comandaExistente.isEmpty()) {
			Pedido pedido = new Pedido();
			pedido.setComanda(comanda);
			comanda.setPedido(pedido);
			return repository.save(comanda);
		}
		throw new RuntimeException("Identificação já está sendo utilizada, adicione outra identificacao");
	}
	
	public Comanda adicionarPedido(Long idComanda, PedidoRequestDTO pedidoDTO) {
		Comanda comanda = this.findById(idComanda);
		if(!comanda.getAberta()) {
			throw new RuntimeException("Abra a comanda para fazer pedido");
		}
		pedidoService.adicionarItensAoPedido(pedidoDTO, comanda.getPedido());
		return repository.save(comanda);
	}
	
	public Comanda fecharComanda(Long id) {
		Comanda comanda = this.findById(id);
		comanda.setAberta(false);
		comanda.setFechamento(LocalDateTime.now());
		return repository.save(comanda);
	}
	
	public List<Comanda> listaComandasAbertas(){
		List<Comanda> comanda = repository.findByAberta(true);
		return comanda;
	}
	
	public List<Comanda> findAll() {
		return repository.findAll();
	}
	
	public Comanda findById(Long id) {
		Optional<Comanda> comanda = repository.findById(id);
		return comanda.get();
	}

	public void deletar(Long id) {
		Comanda comanda = this.findById(id);
		repository.delete(comanda);
	}
}

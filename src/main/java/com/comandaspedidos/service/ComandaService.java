package com.comandaspedidos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.exceptions.RegraDeNegocioException;
import com.comandaspedidos.exceptions.ResourceNotFoundException;
import com.comandaspedidos.models.Comanda;
import com.comandaspedidos.models.FormaDePagamento;
import com.comandaspedidos.models.Pagamento;
import com.comandaspedidos.models.Pedido;
import com.comandaspedidos.models.DTO.PagamentoRequestDTO;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.repository.ComandaRepository;
import com.comandaspedidos.repository.FormaDePagamentoRepository;
import com.comandaspedidos.repository.PagamentoRepository;

@Service
public class ComandaService {
	@Autowired
	private ComandaRepository repository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private FormaDePagamentoRepository formaDePagamentoRepository;
	
	public Comanda abrirComanda(Comanda comanda) {
		Optional<Comanda> comandaExistente = repository.findByAbertaAndIdentificacao(true, comanda.getIdentificacao());
		if(comandaExistente.isEmpty()) {
			Pedido pedido = new Pedido();
			pedido.setComanda(comanda);
			comanda.setPedido(pedido);
			return repository.save(comanda);
		}
		throw new RegraDeNegocioException("Identificação já está sendo utilizada, adicione outra identificacao");
	}
	
	public Comanda adicionarPedido(Long idComanda, PedidoRequestDTO pedidoDTO) {
		Comanda comanda = this.findById(idComanda);
		if(!comanda.getAberta()) {
			throw new RegraDeNegocioException("Abra a comanda para fazer pedido");
		}
		pedidoService.adicionarItensAoPedido(pedidoDTO, comanda.getPedido());
		return repository.save(comanda);
	}
	
	public Comanda adicionarPagamento(PagamentoRequestDTO pagamentoDTO, Long idComanda) {
		Comanda comanda = this.findById(idComanda);
		
		Pagamento pagamento = new Pagamento();
		pagamento.setValorPago(pagamentoDTO.getValorPago());
		FormaDePagamento formaDePagamento = formaDePagamentoRepository.findById(pagamentoDTO.getFormaDePagamento()).orElseThrow(()-> new ResourceNotFoundException("Forma de Pagamento não existe"));
		pagamento.setFormaDePagamento(formaDePagamento);
		pagamento.setPedido(comanda.getPedido());
		pagamentoRepository.save(pagamento);
		
		if(comanda.getAberta()) {
			comanda.getPedido().getPagamento().add(pagamento);
			return repository.save(comanda);
		}
		throw new RegraDeNegocioException("Comanda fechada");
	}
	
	public Comanda fecharComanda(Long id) {
		Comanda comanda = this.findById(id);
		
		if(comanda.getPedido().getPagamentoTotal().compareTo(comanda.getPedido().getValorTotalFinal()) == -1 ) {
			throw new RegraDeNegocioException("Não foi pago o valor total da comanda");
		}
		
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
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comanda não localizada"));
	}

	public void deletar(Long id) {
		Comanda comanda = this.findById(id);
		repository.delete(comanda);
	}
}

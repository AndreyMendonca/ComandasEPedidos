package com.comandaspedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.Comanda;
import com.comandaspedidos.repository.ComandaRepository;

@Service
public class ComandaService {
	@Autowired
	private ComandaRepository repository;
	
	public Comanda abrirComanda(Comanda comanda) {
		Optional<Comanda> comandaExistente = repository.findByAbertaAndIdentificacao(true, comanda.getIdentificacao());
		if(comandaExistente.isEmpty()) {
			return repository.save(comanda);
		}
		throw new RuntimeException("Identificação já está sendo utilizada, adicione outra identificacao");
	}
	
	public Comanda fecharComanda(Long id) {
		Comanda comanda = this.findById(id);
		comanda.setAberta(false);
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

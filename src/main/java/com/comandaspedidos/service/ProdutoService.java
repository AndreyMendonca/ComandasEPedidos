package com.comandaspedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.Produto;
import com.comandaspedidos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto save(Produto produto) {
		return repository.save(produto);
	}
	
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	public Produto findById(Long id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.get();
	}

	public void deletar(Long id) {
		Produto produto = this.findById(id);
		repository.delete(produto);
	}
}

package com.comandaspedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.exceptions.ResourceNotFoundException;
import com.comandaspedidos.models.Produto;
import com.comandaspedidos.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repository;
	
	public Produto save(Produto produto) {
		produto.setAtivo(true);
		return repository.save(produto);
	}
	
	public List<Produto> findAll() {
		return repository.findByAtivo(true);
	}
	
	public Produto findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado"));
	}

	public void deletar(Long id) {
		Produto produto = this.findById(id);
		produto.setAtivo(false);
		repository.save(produto);
	}
	
	public List<Produto> findByNome(String nome){
		return repository.findByAtivoAndNomeContainingIgnoreCase(true, nome);
	}
}

package com.comandaspedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.exceptions.RegraDeNegocioException;
import com.comandaspedidos.exceptions.ResourceNotFoundException;
import com.comandaspedidos.models.Categoria;
import com.comandaspedidos.models.Produto;
import com.comandaspedidos.repository.CategoriaRepository;
import com.comandaspedidos.repository.ProdutoRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Categoria save(Categoria categoria) {
		categoria.setAtivo(true);
		return repository.save(categoria);
	}
	
	public List<Categoria> findAll() {
		return repository.findByAtivo(true);
	}
	
	public Categoria findById(Long id) {
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria não encontrada"));
	}

	public void deletar(Long id) {
		Categoria categoria = this.findById(id);
		List<Produto> produtos = produtoRepository.findByAtivoAndCategoria(true, categoria);
		if(!produtos.isEmpty()) {
			throw new RegraDeNegocioException("Existem produtos vinculados a categoria, exclua eles");
		}
		categoria.setAtivo(false);
		repository.save(categoria);
	}
}

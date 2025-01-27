package com.comandaspedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.Categoria;
import com.comandaspedidos.repository.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria save(Categoria categoria) {
		return repository.save(categoria);
	}
	
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.get();
	}

	public void deletar(Long id) {
		Categoria categoria = this.findById(id);
		repository.delete(categoria);
	}
}

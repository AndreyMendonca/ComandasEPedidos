package com.comandaspedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.exceptions.ResourceNotFoundException;
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
		return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categoria não encontrada"));
	}

	public void deletar(Long id) {
		Categoria categoria = this.findById(id);
		repository.delete(categoria);
	}
}

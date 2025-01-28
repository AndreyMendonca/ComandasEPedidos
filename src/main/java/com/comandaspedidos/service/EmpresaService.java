package com.comandaspedidos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comandaspedidos.models.Empresa;
import com.comandaspedidos.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository repository;
	
	public Empresa save(Empresa empresa) {
		return repository.save(empresa);
	}
	
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa findById(Long id) {
		Optional<Empresa> empresa = repository.findById(id);
		return empresa.get();
	}

	public void deletar(Long id) {
		Empresa empresa = this.findById(id);
		repository.delete(empresa);
	}
}

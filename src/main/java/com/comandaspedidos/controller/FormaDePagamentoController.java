package com.comandaspedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comandaspedidos.models.FormaDePagamento;
import com.comandaspedidos.repository.FormaDePagamentoRepository;

@RestController
@RequestMapping("/formadepagamento")
public class FormaDePagamentoController {
	@Autowired
	private FormaDePagamentoRepository repository;
	
	@PostMapping
	public FormaDePagamento save(@RequestBody FormaDePagamento formaDePagamento) {
		return repository.save(formaDePagamento);
	}
	
	@GetMapping
	public List<FormaDePagamento> findAll() {
		return repository.findAll();
	}
	
}

package com.comandaspedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comandaspedidos.models.Comanda;
import com.comandaspedidos.service.ComandaService;

@RestController
@RequestMapping("/comandas")
@CrossOrigin(origins = "**")
public class ComandaController {
	@Autowired
	private ComandaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Comanda abrirComanda(@RequestBody Comanda comandas) {
		return service.abrirComanda(comandas);
	}
	
	@PutMapping("/{id}/fecharComanda")
	public Comanda fecharComanda(@PathVariable Long id) {
		return service.fecharComanda(id);
	}
	
	@GetMapping("/todas")
	public List<Comanda> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/abertas")
	public List<Comanda> listaDeComandasAbertas() {
		return service.listaComandasAbertas();
	}
	
	@GetMapping("/{id}")
	public Comanda findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}

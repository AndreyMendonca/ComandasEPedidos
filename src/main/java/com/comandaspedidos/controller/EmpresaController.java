package com.comandaspedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.comandaspedidos.models.Empresa;
import com.comandaspedidos.service.EmpresaService;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "**")
public class EmpresaController {
	@Autowired
	private EmpresaService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	private Empresa save(@RequestBody Empresa empresa) {
		return service.save(empresa);
	}
	
	@GetMapping
	private List<Empresa> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	private Empresa findById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	private void delete(@PathVariable Long id){
		service.deletar(id);
	}
}

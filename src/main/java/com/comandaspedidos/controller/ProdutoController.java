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

import com.comandaspedidos.models.Produto;
import com.comandaspedidos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "**")
public class ProdutoController {
	@Autowired
	private ProdutoService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save(@RequestBody Produto produto) {
		return service.save(produto);
	}
	
	@GetMapping
	public List<Produto> getAll(){
		return service.findAll();
	}
	@GetMapping("/nome/{nome}")
	public List<Produto> getAll(@PathVariable String nome){
		return service.findByNome(nome);
	}
	
	@GetMapping("/{id}")
	public Produto getById(@PathVariable Long id){
		return service.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
	

}

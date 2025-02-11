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
import com.comandaspedidos.models.DTO.PagamentoRequestDTO;
import com.comandaspedidos.models.DTO.PedidoRequestDTO;
import com.comandaspedidos.models.DTO.RelatorioVendasDTO;
import com.comandaspedidos.service.ComandaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/comandas")
@CrossOrigin(origins = "**")
@Tag(name = "Comanda", description = "Endpoints para abertura, controle e gerenciamento de comandas")
public class ComandaController {
	@Autowired
	private ComandaService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary = "Abrir uma nova comanda", description = "Abrir uma nova comanda", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "201", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public Comanda abrirComanda(@RequestBody Comanda comandas) {
		return service.abrirComanda(comandas);
	}

	@PutMapping("/{id}/adicionar")
	@Operation(summary = "Adicionar itens a comanda", description = "Adicionar itens a comanda", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public Comanda adicionarItemsAoPedido(@PathVariable Long id, @RequestBody PedidoRequestDTO pedidoDTO) {
		return service.adicionarPedido(id, pedidoDTO);
	}

	@PutMapping("/{id}/fecharComanda")
	@Operation(summary = "Fechar a comanda", description = "Fechamento de comanda", tags = { "Comanda" }, responses = {
			@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public Comanda fecharComanda(@PathVariable Long id) {
		return service.fecharComanda(id);
	}

	@PutMapping("/{id}/pagamento")
	@Operation(summary = "Adicionar forma de pagamento a comanda", description = "Adicionar forma de pagamento a comanda", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public Comanda adicionarPagamento(@RequestBody PagamentoRequestDTO pagamentoDTO, @PathVariable Long id) {
		return service.adicionarPagamento(pagamentoDTO, id);
	}

	@GetMapping("/todas")
	@Operation(summary = "Listar todas comandas", description = "Listar todas comandas", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public List<Comanda> findAll() {
		return service.findAll();
	}

	@GetMapping("/abertas")
	@Operation(summary = "Listar comandas que estão abertas", description = "Listar comandas que estão abertas", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public List<Comanda> listaDeComandasAbertas() {
		return service.listaComandasAbertas();
	}

	@GetMapping("/nome/{identificacao}")
	@Operation(summary = "Buscar comandas pela identificação", description = "Buscar comandas pela identificação", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public List<Comanda> findByIdentificacao(@PathVariable String identificacao) {
		return service.findByIdentificacao(identificacao);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Encontrar comanda por ID", description = "Encontrar comanda por ID", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public Comanda findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/relatorio")
	@Operation(summary = "Relatório simples da aplicação", description = "Relatório simples da aplicação", tags = {
			"Comanda" }, responses = {
					@ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = Comanda.class))),
					@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
					@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
					@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public RelatorioVendasDTO relatorio() {
		return service.relatorio();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(summary = "Excluir uma comanda", description = "Excluir a comanda", tags = { "Comanda" }, responses = {
			@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content) })
	public void delete(@PathVariable Long id) {
		service.deletar(id);
	}
}

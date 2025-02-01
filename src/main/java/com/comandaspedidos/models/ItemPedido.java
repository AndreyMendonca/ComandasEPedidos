package com.comandaspedidos.models;

import java.math.BigDecimal;

import com.comandaspedidos.models.pk.ItemPedidoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_item_pedido")
public class ItemPedido {
	@EmbeddedId
	private ItemPedidoPK id = new ItemPedidoPK();

	private Integer quantidade;
	
	private String observacao;
	
	public ItemPedido() {}
	
	public ItemPedido(Pedido pedido, Produto produto, Integer quantidade, String observacao) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.observacao = observacao;
	}
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public BigDecimal getTotalValorParciar() {
		return this.getProduto().getPrecoVenda().multiply(new BigDecimal(this.quantidade));
	}

}

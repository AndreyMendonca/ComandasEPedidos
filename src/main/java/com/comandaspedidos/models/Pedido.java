package com.comandaspedidos.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_pedido")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy="id.pedido")
	private List<ItemPedido> itens = new ArrayList<>();
	
	@OneToOne(mappedBy = "pedido")
	private Comanda comanda;
	
	@JsonIgnore
	public Comanda getComanda() {
		return this.comanda;
	}
	
	public BigDecimal getValorTotalFinal() {
		BigDecimal valor = BigDecimal.ZERO;
		
		for(ItemPedido item : itens) {
			valor = valor.add(item.getTotalValorParciar());
		}
	
		return valor;
	}
}

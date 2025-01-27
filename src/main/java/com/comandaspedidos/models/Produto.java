package com.comandaspedidos.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_produto")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name="preco_venda")
	private BigDecimal precoVenda;
	
	private Boolean ativo;
	
	@ManyToOne
	@JoinTable(name="categoria_id")
	private Categoria categoria;
}

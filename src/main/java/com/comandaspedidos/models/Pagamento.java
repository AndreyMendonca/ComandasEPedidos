package com.comandaspedidos.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="valor_pago")
	private BigDecimal valorPago;

	@ManyToOne
	@JoinColumn(name="forma_de_pagamento_id")
	private FormaDePagamento formaDePagamento;
	
	@ManyToOne
	@JoinColumn(name="pagamento_id")
	@JsonIgnore
	private Pedido pedido;

}

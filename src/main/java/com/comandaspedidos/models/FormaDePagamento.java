package com.comandaspedidos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tb_forma_de_pagamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class FormaDePagamento {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique = true, nullable = false)
	private String identificacao;
}

package com.comandaspedidos.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="tb_comanda")	
@Data
@EqualsAndHashCode
public class Comanda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String identificacao;
	private Boolean aberta;
	private LocalDateTime abertura;
	private LocalDateTime fechamento;
	
	public Comanda() {
		this.aberta = true;
		this.abertura = LocalDateTime.now();
	}
}

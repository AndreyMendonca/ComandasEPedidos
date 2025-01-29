package com.comandaspedidos.models;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="pedido_id")
	private Pedido pedido;
	
	public Comanda() {
		this.aberta = true;
		this.abertura = LocalDateTime.now();
	}
}

package com.comandaspedidos.models.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PagamentoRequestDTO {
	private Long formaDePagamento;
	private BigDecimal valorPago;
}

package com.comandaspedidos.models.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioVendasDTO {
	private Integer vendasDia;
	private BigDecimal totalReaisDia;
	private BigDecimal totalReaisMes;
}

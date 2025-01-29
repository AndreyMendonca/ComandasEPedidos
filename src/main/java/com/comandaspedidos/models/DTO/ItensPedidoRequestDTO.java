package com.comandaspedidos.models.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class ItensPedidoRequestDTO {
	private Long idProduto;
	private Integer quantidade;
	private String observacao;
}

package com.comandaspedidos.models.DTO;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class PedidoRequestDTO {
	private List<ItensPedidoRequestDTO> itens = new ArrayList<>();
}

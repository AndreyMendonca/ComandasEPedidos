package com.comandaspedidos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comandaspedidos.models.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	List<Comanda> findByAberta(Boolean aberta);
	Optional<Comanda> findByAbertaAndIdentificacao(Boolean aberta, String identificacao);
}

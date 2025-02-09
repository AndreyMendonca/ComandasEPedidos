package com.comandaspedidos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.comandaspedidos.models.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long>{
	List<Comanda> findByAberta(Boolean aberta);
	Optional<Comanda> findByAbertaAndIdentificacao(Boolean aberta, String identificacao);
	List<Comanda> findByAbertaAndIdentificacaoContainingIgnoreCase(Boolean aberta, String identificacao);
    
	@Query("SELECT c FROM Comanda c WHERE DATE(c.abertura) = CURRENT_DATE")
    List<Comanda> findComandasDoDia();

    @Query("SELECT c FROM Comanda c WHERE MONTH(c.abertura) = MONTH(CURRENT_DATE) AND YEAR(c.abertura) = YEAR(CURRENT_DATE)")
    List<Comanda> findComandasDoMes();
}

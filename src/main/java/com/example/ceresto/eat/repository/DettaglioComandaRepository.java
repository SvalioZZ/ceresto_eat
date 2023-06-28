package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.DettaglioComanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface DettaglioComandaRepository extends JpaRepository <DettaglioComanda, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update dettaglio_comanda SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(StatusEnum status, Long id);

    Optional<DettaglioComanda> findByStatus(StatusEnum status);
}

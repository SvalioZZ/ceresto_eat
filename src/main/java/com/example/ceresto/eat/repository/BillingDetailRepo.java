package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.StatusEnum;
import com.example.ceresto.eat.model.BillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface BillingDetailRepo extends JpaRepository <BillingDetail, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update billing_detail SET status = :status WHERE id = :id", nativeQuery = true)
    void updateStatusById(StatusEnum status, Long id);

    Optional<BillingDetail> findByStatus(StatusEnum status);
}

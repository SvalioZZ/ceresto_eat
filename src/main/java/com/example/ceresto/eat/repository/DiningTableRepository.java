package com.example.ceresto.eat.repository;

import com.example.ceresto.eat.enumerati.RecordStatus;
import com.example.ceresto.eat.model.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DiningTableRepository extends JpaRepository<DiningTable, Long> {
    @Transactional
    @Modifying(flushAutomatically = true)
    @Query(value = "update Dining_table SET status = :status WHERE table_id = :table_id")
    void updateStatusById(@Param(value = "status") RecordStatus status, @Param(value = "table_id") Long id);


}

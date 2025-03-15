package com.prado.paulo.FinanceFlow.domain.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.transaction.model.Transaction;

@Repository
public interface TranscationRepository extends JpaRepository<Transaction, String> {

}

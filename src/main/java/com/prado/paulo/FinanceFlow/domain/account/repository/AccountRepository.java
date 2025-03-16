package com.prado.paulo.FinanceFlow.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.account.model.Account;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByName(String name);

    boolean existsByUserIdAndName(String userId, String name);

    @Transactional
    void deleteByName(String name);
}

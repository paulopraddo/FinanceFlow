package com.prado.paulo.FinanceFlow.domain.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.account.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

}

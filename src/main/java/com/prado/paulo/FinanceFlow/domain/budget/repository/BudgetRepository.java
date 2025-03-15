package com.prado.paulo.FinanceFlow.domain.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.budget.model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, String> {

}

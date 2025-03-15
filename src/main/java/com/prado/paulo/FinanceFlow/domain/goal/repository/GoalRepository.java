package com.prado.paulo.FinanceFlow.domain.goal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.goal.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, String> {

}

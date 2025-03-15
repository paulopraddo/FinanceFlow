package com.prado.paulo.FinanceFlow.domain.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prado.paulo.FinanceFlow.domain.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}

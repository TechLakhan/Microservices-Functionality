package com.lakhan.expense_service.repository;

import com.lakhan.expense_service.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}

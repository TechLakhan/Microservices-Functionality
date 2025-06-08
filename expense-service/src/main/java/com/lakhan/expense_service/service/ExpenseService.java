package com.lakhan.expense_service.service;

import com.lakhan.expense_service.dto.ExpenseServiceDto;
import com.lakhan.expense_service.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<ExpenseServiceDto> getAllExpenses();
}

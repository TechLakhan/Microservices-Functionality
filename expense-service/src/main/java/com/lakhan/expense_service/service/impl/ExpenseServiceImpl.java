package com.lakhan.expense_service.service.impl;

import com.lakhan.expense_service.client.UserClient;
import com.lakhan.expense_service.dto.ExpenseServiceDto;
import com.lakhan.expense_service.model.Expense;
import com.lakhan.expense_service.repository.ExpenseRepository;
import com.lakhan.expense_service.service.ExpenseService;
import com.techlakhan.common.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    private UserClient userClient;

    @Override
    public List<ExpenseServiceDto> getAllExpenses() {
        List<Expense> all = expenseRepository.findAll();
        List<ExpenseServiceDto> response = all.stream().map(expense -> {
            ExpenseServiceDto dto = new ExpenseServiceDto();
            dto.setId(expense.getId());
            dto.setAmount(expense.getAmount());
            dto.setDescription(expense.getDescription());
            dto.setUsername(expense.getUsername());

            UserDTO user = userClient.getUserByUsername(expense.getUsername());
            dto.setUser(user);

            return dto;
        }).collect(Collectors.toList());

        return response;
    }
}

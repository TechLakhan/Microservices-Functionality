package com.lakhan.expense_service.controller;

import com.lakhan.expense_service.client.UserClient;
import com.lakhan.expense_service.model.Expense;
import com.lakhan.expense_service.repository.ExpenseRepository;
import com.techlakhan.common.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserClient userClient;

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        return new ResponseEntity<>(expenseRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveExpense(@RequestBody Expense expense) {
        try {
            UserDTO user = userClient.getUserByUsername(expense.getUsername());
            if (user == null) {
                return ResponseEntity.badRequest().body("User not found");
            }
            return ResponseEntity.ok("Expense saved for the user : " + user.getUsername());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("User-service is down");
        }
    }


}

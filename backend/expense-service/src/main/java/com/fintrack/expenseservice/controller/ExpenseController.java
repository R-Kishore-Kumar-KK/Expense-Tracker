package com.fintrack.expenseservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintrack.expenseservice.dto.ExpenseRequest;
import com.fintrack.expenseservice.entity.Expense;
import com.fintrack.expenseservice.service.ExpenseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	private final ExpenseService service;

	public ExpenseController(ExpenseService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Expense> createExpense(@Valid @RequestBody ExpenseRequest request) {
		Expense expense = service.createExpense(request);
		return new ResponseEntity<>(expense, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Expense>> getAllExpenses() {
		return ResponseEntity.ok(service.getAllExpense());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
		return ResponseEntity.ok(service.getExpenseById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @Valid @RequestBody ExpenseRequest request) {
		return ResponseEntity.ok(service.updateExpense(id, request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Expense> deleteExpense(@PathVariable Long id) {
		service.deleteExpense(id);
		return ResponseEntity.noContent().build();
	}
}

package com.fintrack.expenseservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.expenseservice.dto.ExpenseRequest;
import com.fintrack.expenseservice.entity.Expense;
import com.fintrack.expenseservice.exception.ExpenseNotFoundException;
import com.fintrack.expenseservice.repository.ExpenseRepository;
import com.fintrack.expenseservice.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService{

	private final ExpenseRepository repository;

	public ExpenseServiceImpl(ExpenseRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Expense createExpense(ExpenseRequest request) {
		
		Expense expense = new Expense();
		
		expense.setTitle(request.getTitle());
		expense.setAmount(request.getAmount());
		expense.setCategory(request.getCategory());
		expense.setDescription(request.getDescription());
		expense.setExpenseDate(request.getExpenseDate());
		expense.setPaymentMethod(request.getPaymentMethod());
		
		return repository.save(expense);
	}

	@Override
	public List<Expense> getAllExpense() {
		return repository.findAll();
	}

	@Override
	public Expense getExpenseById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ExpenseNotFoundException(id));
	}

	@Override
	public Expense updateExpense(Long id, ExpenseRequest request) {
		
		Expense expense = new Expense();
		
		expense.setTitle(request.getTitle());
		expense.setAmount(request.getAmount());
		expense.setCategory(request.getCategory());
		expense.setDescription(request.getDescription());
		expense.setExpenseDate(request.getExpenseDate());
		expense.setPaymentMethod(request.getPaymentMethod());
		
		return repository.save(expense);
	}

	@Override
	public void deleteExpense(Long id) {
		Expense expense = getExpenseById(id);
		repository.delete(expense);
	}
	
	
}

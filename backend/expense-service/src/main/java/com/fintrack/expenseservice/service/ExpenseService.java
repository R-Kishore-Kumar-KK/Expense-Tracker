package com.fintrack.expenseservice.service;

import java.util.List;

import com.fintrack.expenseservice.dto.ExpenseRequest;
import com.fintrack.expenseservice.entity.Expense;

public interface ExpenseService {

	public Expense createExpense(ExpenseRequest request);
	
	public List<Expense> getAllExpense();
	
	public Expense getExpenseById(Long id);
	
	public Expense updateExpense(Long id, ExpenseRequest request);
	
	public void deleteExpense(Long id);
}

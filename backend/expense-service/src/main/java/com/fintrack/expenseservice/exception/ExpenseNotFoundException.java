package com.fintrack.expenseservice.exception;

public class ExpenseNotFoundException extends RuntimeException{

	public ExpenseNotFoundException(Long id) {
		super("Expense not found with the id: " + id);
	}

}

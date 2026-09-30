package com.fintrack.loanservice.exception;

public class LoanNotFoundException extends RuntimeException{

	public LoanNotFoundException(Long id) {
        super("Loan not found with id: " + id);
    }
}

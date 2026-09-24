package com.fintrack.investmentservice.exception;

public class InvestmentNotFoundException extends RuntimeException{

	public InvestmentNotFoundException(Long id) {
        super("Investment not found with id: " + id);
    }
}

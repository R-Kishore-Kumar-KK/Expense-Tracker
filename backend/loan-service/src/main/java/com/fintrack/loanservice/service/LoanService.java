package com.fintrack.loanservice.service;

import java.util.List;

import com.fintrack.loanservice.dto.LoanRequest;
import com.fintrack.loanservice.entity.Loan;

public interface LoanService {

	public Loan createLoan(LoanRequest request);

    public List<Loan> getAllLoans();

    public Loan getLoanById(Long id);

    public Loan updateLoan(Long id, LoanRequest request);

    public void deleteLoan(Long id);
}

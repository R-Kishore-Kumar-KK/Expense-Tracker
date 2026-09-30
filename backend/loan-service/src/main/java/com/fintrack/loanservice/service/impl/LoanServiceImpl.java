package com.fintrack.loanservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.loanservice.dto.LoanRequest;
import com.fintrack.loanservice.entity.Loan;
import com.fintrack.loanservice.exception.LoanNotFoundException;
import com.fintrack.loanservice.repository.LoanRepository;
import com.fintrack.loanservice.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

	private final LoanRepository repository;

	public LoanServiceImpl(LoanRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Loan createLoan(LoanRequest request) {

		Loan loan = new Loan();

		loan.setLenderName(request.getLenderName());
		loan.setLoanType(request.getLoanType());
		loan.setPrincipalAmount(request.getPrincipalAmount());
		loan.setInterestRate(request.getInterestRate());
		loan.setTenureMonths(request.getTenureMonths());
		loan.setEmiAmount(request.getEmiAmount());
		loan.setOutstandingAmount(request.getOutstandingAmount());
		loan.setStartDate(request.getStartDate());
		loan.setEndDate(request.getEndDate());
		loan.setNotes(request.getNotes());

		return repository.save(loan);
	}

	@Override
	public List<Loan> getAllLoans() {
		return repository.findAll();
	}

	@Override
	public Loan getLoanById(Long id) {

		return repository.findById(id).orElseThrow(() -> new LoanNotFoundException(id));
	}

	@Override
	public Loan updateLoan(Long id, LoanRequest request) {

		Loan loan = getLoanById(id);

		loan.setLenderName(request.getLenderName());
		loan.setLoanType(request.getLoanType());
		loan.setPrincipalAmount(request.getPrincipalAmount());
		loan.setInterestRate(request.getInterestRate());
		loan.setTenureMonths(request.getTenureMonths());
		loan.setEmiAmount(request.getEmiAmount());
		loan.setOutstandingAmount(request.getOutstandingAmount());
		loan.setStartDate(request.getStartDate());
		loan.setEndDate(request.getEndDate());
		loan.setNotes(request.getNotes());

		return repository.save(loan);
	}

	@Override
	public void deleteLoan(Long id) {

		Loan loan = getLoanById(id);

		repository.delete(loan);
	}
}

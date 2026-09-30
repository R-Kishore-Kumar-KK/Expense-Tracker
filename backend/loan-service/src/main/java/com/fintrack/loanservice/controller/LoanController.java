package com.fintrack.loanservice.controller;

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

import com.fintrack.loanservice.dto.LoanRequest;
import com.fintrack.loanservice.entity.Loan;
import com.fintrack.loanservice.service.LoanService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	private final LoanService service;

	public LoanController(LoanService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Loan> createLoan(@Valid @RequestBody LoanRequest request) {

		Loan loan = service.createLoan(request);

		return new ResponseEntity<>(loan, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Loan>> getAllLoans() {

		return ResponseEntity.ok(service.getAllLoans());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getLoanById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable Long id, @Valid @RequestBody LoanRequest request) {

		return ResponseEntity.ok(service.updateLoan(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {

		service.deleteLoan(id);

		return ResponseEntity.noContent().build();
	}
}

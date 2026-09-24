package com.fintrack.investmentservice.controller;

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

import com.fintrack.investmentservice.dto.InvestmentRequest;
import com.fintrack.investmentservice.entity.Investment;
import com.fintrack.investmentservice.service.InvestmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

	private final InvestmentService service;

	public InvestmentController(InvestmentService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Investment> createInvestment(@Valid @RequestBody InvestmentRequest request) {

		Investment investment = service.createInvestment(request);

		return new ResponseEntity<>(investment, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Investment>> getAllInvestments() {

		return ResponseEntity.ok(service.getAllInvestments());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getInvestmentById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Investment> updateInvestment(@PathVariable Long id,
			@Valid @RequestBody InvestmentRequest request) {

		return ResponseEntity.ok(service.updateInvestment(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {

		service.deleteInvestment(id);

		return ResponseEntity.noContent().build();
	}
}

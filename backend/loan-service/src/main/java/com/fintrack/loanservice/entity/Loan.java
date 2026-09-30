package com.fintrack.loanservice.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String lenderName;
	
	@Column(nullable = false)
	private String loanType;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal principalAmount;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal interestRate;
	
	@Column(nullable = false)
	private int tenureMonths;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal emiAmount;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal outstandingAmount;
	
	@Column(nullable = false)
	private LocalDate startDate;
	
	@Column(nullable = false)
	private LocalDate endDate;
	
	private String notes;
}

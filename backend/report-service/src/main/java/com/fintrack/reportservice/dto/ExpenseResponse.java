package com.fintrack.reportservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseResponse {

	private Long id;
	
	private String title;
	
	private BigDecimal amount;
	
	private String category;
	
	private String description;
	
	private LocalDate expenseDate;
	
	private String paymentMethod;
}

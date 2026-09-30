package com.fintrack.reportservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanResponse {

	private Long id;
    
	private String lenderName;
    
	private String loanType;
    
	private BigDecimal principalAmount;
    
	private BigDecimal interestRate;
    
	private Integer tenureMonths;
    
	private BigDecimal emiAmount;
    
	private BigDecimal outstandingAmount;
    
	private LocalDate startDate;
    
	private LocalDate endDate;
    
	private String notes;
}

package com.fintrack.loanservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanRequest {

	@NotBlank(message = "Lender name is required")
	private String lenderName;
	
	@NotBlank(message = "Loan type is required")
	private String loanType;
	
	@NotNull(message = "Principal amount is required")
    @DecimalMin(value = "0.01", message = "Principal amount must be greater than 0")
	private BigDecimal principalAmount;
	
	@NotNull(message = "Interest rate is required")
    @DecimalMin(value = "0.00", message = "Interest rate cannot be negative")
	private BigDecimal interestRate;
	
	@NotNull(message = "Tenure is required")
    @Min(value = 1, message = "Tenure must be at least 1 month")
	private int tenureMonths;
	
	@NotNull(message = "EMI amount is required")
	@DecimalMin(value = "0.01", message = "EMI amount must be greater than 0")
	private BigDecimal emiAmount;
	
	@NotNull(message = "Outstanding amount is required")
    @DecimalMin(value = "0.00", message = "Outstanding amount cannot be negative")
	private BigDecimal outstandingAmount;
	
	@NotNull(message = "Start date is required")
	private LocalDate startDate;
	
	@NotNull(message = "End date is required")
	private LocalDate endDate;
	
	private String notes;
}

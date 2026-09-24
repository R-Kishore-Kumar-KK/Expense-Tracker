package com.fintrack.investmentservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentRequest {

	@NotBlank(message = "Investment Name is Required")
	private String name;
	
	@NotBlank(message = "Investment Type is Required")
	private String type;
	
	@NotNull(message = "Invested amount is required")
    @DecimalMin(value = "0.01", message = "Invested amount must be greater than 0")
	private BigDecimal investedAmount;
	
	@NotNull(message = "Current value is required")
    @DecimalMin(value = "0.00", message = "Current value cannot be negative")
	private BigDecimal currentValue;
	
	@NotNull(message = "Investment date is required")
	private LocalDate investmentDate;
	
	private String notes;
}

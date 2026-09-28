package com.fintrack.goalservice.dto;

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
public class GoalRequest {

	@NotBlank(message = "Goal Name is Required")
	private String name;
	
	@NotNull(message = "Target amount is required")
    @DecimalMin(value = "0.01", message = "Target amount must be greater than 0")
	private BigDecimal targetAmount;
	
	@NotNull(message = "Current amount is required")
    @DecimalMin(value = "0.00", message = "Current amount cannot be negative")
	private BigDecimal currentAmount;
	
	@NotNull(message = "Target date is required")
	private LocalDate targetDate;
	
	@NotBlank(message = "Category is required")
	private String category;
	
	private String description;
	
}

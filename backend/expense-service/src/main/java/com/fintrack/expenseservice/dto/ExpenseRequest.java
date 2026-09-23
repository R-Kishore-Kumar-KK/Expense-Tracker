package com.fintrack.expenseservice.dto;

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
public class ExpenseRequest {

	@NotBlank(message = "Title is Required")
	private String title;
	
	@NotNull(message = "Amount is Required")
	@DecimalMin(value = "0.01", message = "Amount must be greater than 0")
	private BigDecimal amount;
	
	@NotBlank(message = "Category is Required")
	private String category;
	
	private String description;
	
	@NotNull(message = "Expense Date is Required")
	private LocalDate expenseDate;
	
	@NotBlank(message = "Payement Method is Required")
	private String paymentMethod;
}

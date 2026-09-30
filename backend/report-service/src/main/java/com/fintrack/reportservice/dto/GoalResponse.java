package com.fintrack.reportservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoalResponse {

	private Long id;
    
	private String name;
    
	private BigDecimal targetAmount;
    
	private BigDecimal currentAmount;
    
	private LocalDate targetDate;
    
	private String category;
    
	private String description;
}

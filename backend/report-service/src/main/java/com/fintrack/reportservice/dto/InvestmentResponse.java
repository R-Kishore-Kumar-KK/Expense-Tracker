package com.fintrack.reportservice.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestmentResponse {

	private Long id;
	
    private String name;
    
    private String type;
    
    private BigDecimal investedAmount;
    
    private BigDecimal currentValue;
    
    private LocalDate investmentDate;
    
    private String notes;
}

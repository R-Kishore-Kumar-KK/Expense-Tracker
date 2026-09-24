package com.fintrack.investmentservice.entity;

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
@Table(name = "investment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal investedAmount;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal currentValue;
	
	@Column(nullable = false)
	private LocalDate investmentDate;
	
	private String notes;
}

package com.fintrack.expenseservice.entity;

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
@Table(name = "Expense")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal amount;
	
	@Column(nullable = false)
	private String category;
	
	private String description;
	
	@Column(nullable = false)
	private LocalDate expenseDate;
	
	@Column(nullable = false)
	private String paymentMethod;
}

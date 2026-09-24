package com.fintrack.investmentservice.service;

import java.util.List;

import com.fintrack.investmentservice.dto.InvestmentRequest;
import com.fintrack.investmentservice.entity.Investment;

public interface InvestmentService {

	public Investment createInvestment(InvestmentRequest request);
	
	public List<Investment> getAllInvestments();
	
	public Investment getInvestmentById(Long id);
	
	public Investment updateInvestment(Long id, InvestmentRequest request);
	
	public void deleteInvestment(Long id);
}

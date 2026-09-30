package com.fintrack.reportservice.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardReport {

	private BigDecimal totalExpenses;
    
	private BigDecimal totalInvested;
    
	private BigDecimal totalInvestmentValue;
    
	private BigDecimal totalGoalTarget;
    
	private BigDecimal totalGoalCurrent;
    
	private BigDecimal totalLoanOutstanding;
    
	private BigDecimal totalMonthlyEmi;

    private List<ExpenseResponse> expenses;
    
    private List<InvestmentResponse> investments;
    
    private List<GoalResponse> goals;
    
    private List<LoanResponse> loans;
}

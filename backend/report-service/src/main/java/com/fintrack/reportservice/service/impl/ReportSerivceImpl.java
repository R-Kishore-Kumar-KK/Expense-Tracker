package com.fintrack.reportservice.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.reportservice.clients.ExpenseClient;
import com.fintrack.reportservice.clients.GoalClient;
import com.fintrack.reportservice.clients.InvestmentClient;
import com.fintrack.reportservice.clients.LoanClient;
import com.fintrack.reportservice.dto.DashboardReport;
import com.fintrack.reportservice.dto.ExpenseResponse;
import com.fintrack.reportservice.dto.GoalResponse;
import com.fintrack.reportservice.dto.InvestmentResponse;
import com.fintrack.reportservice.dto.LoanResponse;
import com.fintrack.reportservice.service.ReportService;

@Service
public class ReportSerivceImpl implements ReportService {

	private final ExpenseClient expenseClient;
	private final InvestmentClient investmentClient;
	private final GoalClient goalClient;
	private final LoanClient loanClient;
	
	public ReportSerivceImpl(ExpenseClient expenseClient, InvestmentClient investmentClient, GoalClient goalClient,
			LoanClient loanClient) {
		super();
		this.expenseClient = expenseClient;
		this.investmentClient = investmentClient;
		this.goalClient = goalClient;
		this.loanClient = loanClient;
	}

	@Override
	public DashboardReport getDashboardReport() {

		List<ExpenseResponse> expenses = expenseClient.getAllExpenses();

		List<InvestmentResponse> investments = investmentClient.getAllInvestments();

		List<GoalResponse> goals = goalClient.getAllGoals();

		List<LoanResponse> loans = loanClient.getAllLoans();

		BigDecimal totalExpenses = expenses.stream().map(ExpenseResponse::getAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		BigDecimal totalInvested = investments.stream().map(InvestmentResponse::getInvestedAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal totalInvestmentValue = investments.stream().map(InvestmentResponse::getCurrentValue)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		BigDecimal totalGoalTarget = goals.stream().map(GoalResponse::getTargetAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		BigDecimal totalGoalCurrent = goals.stream().map(GoalResponse::getCurrentAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		BigDecimal totalLoanOutstanding = loans.stream().map(LoanResponse::getOutstandingAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		BigDecimal totalMonthlyEmi = loans.stream().map(LoanResponse::getEmiAmount).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		DashboardReport report = new DashboardReport();

		report.setTotalExpenses(totalExpenses);
		report.setTotalInvested(totalInvested);
		report.setTotalInvestmentValue(totalInvestmentValue);
		report.setTotalGoalTarget(totalGoalTarget);
		report.setTotalGoalCurrent(totalGoalCurrent);
		report.setTotalLoanOutstanding(totalLoanOutstanding);
		report.setTotalMonthlyEmi(totalMonthlyEmi);

		report.setExpenses(expenses);
		report.setInvestments(investments);
		report.setGoals(goals);
		report.setLoans(loans);

		return report;
	}
}

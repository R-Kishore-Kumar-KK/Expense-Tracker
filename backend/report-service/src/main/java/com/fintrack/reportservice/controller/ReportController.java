package com.fintrack.reportservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/api/reports")
public class ReportController {

	private final ExpenseClient expenseClient;
	private final InvestmentClient investmentClient;
	private final GoalClient goalClient;
	private final LoanClient loanClient;
	private final ReportService reportService;

	public ReportController(ExpenseClient expenseClient, InvestmentClient investmentClient, GoalClient goalClient,
			LoanClient loanClient, ReportService reportService) {
		super();
		this.expenseClient = expenseClient;
		this.investmentClient = investmentClient;
		this.goalClient = goalClient;
		this.loanClient = loanClient;
		this.reportService = reportService;
	}

	@GetMapping("/expenses")
	public List<ExpenseResponse> getExpensesForReport() {
		return expenseClient.getAllExpenses();
	}
	
	@GetMapping("/investments")
	public List<InvestmentResponse> getInvestmentsForReport() {
		return investmentClient.getAllInvestments();
	}
	
	@GetMapping("/goals")
	public List<GoalResponse> getGoalsForReport() {
		return goalClient.getAllGoals();
	}
	
	@GetMapping("/loans")
	public List<LoanResponse> getLoansForReport() {
		return loanClient.getAllLoans();
	}
	
	@GetMapping("/dashboard")
    public DashboardReport getDashboardReport() {
        return reportService.getDashboardReport();
    }
}

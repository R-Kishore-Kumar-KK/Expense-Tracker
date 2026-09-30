package com.fintrack.reportservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fintrack.reportservice.dto.ExpenseResponse;

@FeignClient(name = "expense-service")
public interface ExpenseClient {

	@GetMapping("/api/expenses")
	public List<ExpenseResponse> getAllExpenses();
}

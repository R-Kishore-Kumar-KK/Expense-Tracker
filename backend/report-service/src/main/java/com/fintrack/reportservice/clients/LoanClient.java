package com.fintrack.reportservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fintrack.reportservice.dto.GoalResponse;
import com.fintrack.reportservice.dto.LoanResponse;

@FeignClient(name = "loan-service")
public interface LoanClient {

	@GetMapping("/api/loans")
	public List<LoanResponse> getAllLoans();
}

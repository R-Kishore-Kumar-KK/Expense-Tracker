package com.fintrack.reportservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fintrack.reportservice.dto.InvestmentResponse;

@FeignClient("investment-service")
public interface InvestmentClient {

	@GetMapping("/api/investments")
	public List<InvestmentResponse> getAllInvestments();
}

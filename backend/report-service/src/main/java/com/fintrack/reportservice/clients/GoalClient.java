package com.fintrack.reportservice.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.fintrack.reportservice.dto.GoalResponse;

@FeignClient(name = "goal-service")
public interface GoalClient {

	@GetMapping("/api/goals")
	public List<GoalResponse> getAllGoals();
}

package com.fintrack.goalservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fintrack.goalservice.dto.GoalRequest;
import com.fintrack.goalservice.entity.Goal;
import com.fintrack.goalservice.service.GoalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

	private final GoalService service;

	public GoalController(GoalService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Goal> createGoal(@Valid @RequestBody GoalRequest request) {

		Goal goal = service.createGoal(request);

		return new ResponseEntity<>(goal, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Goal>> getAllGoals() {

		return ResponseEntity.ok(service.getAllGoals());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {

		return ResponseEntity.ok(service.getGoalById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @Valid @RequestBody GoalRequest request) {

		return ResponseEntity.ok(service.updateGoal(id, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {

		service.deleteGoal(id);

		return ResponseEntity.noContent().build();
	}
}

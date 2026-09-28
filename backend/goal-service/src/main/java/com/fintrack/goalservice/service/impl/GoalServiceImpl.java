package com.fintrack.goalservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.goalservice.dto.GoalRequest;
import com.fintrack.goalservice.entity.Goal;
import com.fintrack.goalservice.exception.GoalNotFoundException;
import com.fintrack.goalservice.repository.GoalRepository;
import com.fintrack.goalservice.service.GoalService;

@Service
public class GoalServiceImpl implements GoalService {

	private final GoalRepository repository;

	public GoalServiceImpl(GoalRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Goal createGoal(GoalRequest request) {
		Goal goal = new Goal();

		goal.setName(request.getName());
		goal.setTargetAmount(request.getTargetAmount());
		goal.setCurrentAmount(request.getCurrentAmount());
		goal.setTargetDate(request.getTargetDate());
		goal.setCategory(request.getCategory());
		goal.setDescription(request.getDescription());

		return repository.save(goal);
	}

	@Override
	public List<Goal> getAllGoals() {
		return repository.findAll();
	}

	@Override
	public Goal getGoalById(Long id) {
		return repository.findById(id).orElseThrow(() -> new GoalNotFoundException(id));
	}

	@Override
	public Goal updateGoal(Long id, GoalRequest request) {
		Goal goal = getGoalById(id);

		goal.setName(request.getName());
		goal.setTargetAmount(request.getTargetAmount());
		goal.setCurrentAmount(request.getCurrentAmount());
		goal.setTargetDate(request.getTargetDate());
		goal.setCategory(request.getCategory());
		goal.setDescription(request.getDescription());

		return repository.save(goal);
	}

	@Override
	public void deleteGoal(Long id) {
		Goal goal = getGoalById(id);

		repository.delete(goal);
	}

}

package com.fintrack.goalservice.service;

import java.util.List;

import com.fintrack.goalservice.dto.GoalRequest;
import com.fintrack.goalservice.entity.Goal;

public interface GoalService {

	public Goal createGoal(GoalRequest request);

    public List<Goal> getAllGoals();

    public Goal getGoalById(Long id);

    public Goal updateGoal(Long id, GoalRequest request);

    public void deleteGoal(Long id);
}

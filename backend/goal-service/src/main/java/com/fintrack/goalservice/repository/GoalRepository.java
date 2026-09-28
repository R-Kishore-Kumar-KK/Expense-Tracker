package com.fintrack.goalservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrack.goalservice.entity.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long>{

}

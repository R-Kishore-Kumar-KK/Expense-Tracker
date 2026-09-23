package com.fintrack.expenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrack.expenseservice.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}

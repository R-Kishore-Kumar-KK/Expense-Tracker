package com.fintrack.loanservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrack.loanservice.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}

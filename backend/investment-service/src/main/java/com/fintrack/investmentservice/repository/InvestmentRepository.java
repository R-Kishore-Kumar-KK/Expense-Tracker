package com.fintrack.investmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fintrack.investmentservice.entity.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long>{

}

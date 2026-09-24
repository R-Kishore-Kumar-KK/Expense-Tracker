package com.fintrack.investmentservice.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fintrack.investmentservice.dto.InvestmentRequest;
import com.fintrack.investmentservice.entity.Investment;
import com.fintrack.investmentservice.exception.InvestmentNotFoundException;
import com.fintrack.investmentservice.repository.InvestmentRepository;
import com.fintrack.investmentservice.service.InvestmentService;

@Service
public class InvestmentServiceImpl implements InvestmentService {

	private final InvestmentRepository repository;

	public InvestmentServiceImpl(InvestmentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Investment createInvestment(InvestmentRequest request) {
		Investment investment = new Investment();

		investment.setName(request.getName());
		investment.setType(request.getType());
		investment.setInvestedAmount(request.getInvestedAmount());
		investment.setCurrentValue(request.getCurrentValue());
		investment.setInvestmentDate(request.getInvestmentDate());
		investment.setNotes(request.getNotes());

		return repository.save(investment);
	}

	@Override
	public List<Investment> getAllInvestments() {
		return repository.findAll();
	}

	@Override
	public Investment getInvestmentById(Long id) {
		return repository.findById(id).orElseThrow(() -> new InvestmentNotFoundException(id));
	}

	@Override
	public Investment updateInvestment(Long id, InvestmentRequest request) {
		Investment investment = getInvestmentById(id);

        investment.setName(request.getName());
        investment.setType(request.getType());
        investment.setInvestedAmount(request.getInvestedAmount());
        investment.setCurrentValue(request.getCurrentValue());
        investment.setInvestmentDate(request.getInvestmentDate());
        investment.setNotes(request.getNotes());

        return repository.save(investment);
	}

	@Override
	public void deleteInvestment(Long id) {
		Investment investment = getInvestmentById(id);

		repository.delete(investment);
	}

}

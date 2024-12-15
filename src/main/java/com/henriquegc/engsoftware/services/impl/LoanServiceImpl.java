package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.repositories.LoanRepository;
import com.henriquegc.engsoftware.services.ILoanService;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements ILoanService {
    private final LoanRepository loanRepository;
    
    public LoanServiceImpl(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }


    @Override
    public List<Loan> getLoans() {
        return this.loanRepository.findAll();
    }


    @Override
    public void createLoan(Loan loan) {
        this.loanRepository.save(loan);
    }


    @Override
    public Optional<Loan> getLoanById(Long id) {
        return this.loanRepository.findById(id);
    }


    @Override
    public double calculateFine(Long id) {
        return this.getLoanById(id).map(Loan::calculateTotalFine).orElse(0.0);
    }
    
}

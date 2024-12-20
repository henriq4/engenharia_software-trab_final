package com.henriquegc.engsoftware.services;

import java.util.List;
import java.util.Optional;

import com.henriquegc.engsoftware.dtos.loan.CreateLoanDTO;
import com.henriquegc.engsoftware.models.Loan;

public interface ILoanService {
    List<Loan> getLoans();
    public void createLoan(CreateLoanDTO loan);
    public Optional<Loan> getLoanById(Long id);
    public double calculateFine(Long id);
}

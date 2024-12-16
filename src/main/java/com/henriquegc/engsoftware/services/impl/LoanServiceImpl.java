package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.dtos.loan.CreateLoanDTO;
import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.repositories.LoanRepository;
import com.henriquegc.engsoftware.repositories.StudentRepository;
import com.henriquegc.engsoftware.services.IItemLoanService;
import com.henriquegc.engsoftware.services.ILoanService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import static com.henriquegc.engsoftware.mappers.LoanMapper.mapToLoan;

@Service
public class LoanServiceImpl implements ILoanService {
    private final LoanRepository loanRepository;
    private final StudentRepository studentRepository;
    private final IItemLoanService itemLoanService;
    
    public LoanServiceImpl(LoanRepository loanRepository, StudentRepository studentRepository, IItemLoanService itemLoanService) {
        this.loanRepository = loanRepository;
        this.studentRepository = studentRepository;
        this.itemLoanService = itemLoanService;
    }

    @Override
    public List<Loan> getLoans() {
        var loans = this.loanRepository.findAll();

        return loans;
    }

    public void createLoan(CreateLoanDTO loan) {
        var student = this.studentRepository.findById(loan.getStudentId())
            .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        
        var newLoan = this.loanRepository.save(mapToLoan(loan, student));

        this.itemLoanService.createItemsLoanByLoan(loan.getItems(), newLoan);

    }

    @Override
    public Optional<Loan> getLoanById(Long id) {
        return this.loanRepository.findById(id);
    }

    @Override
    public double calculateFine(Long id) {
        var itemLoans = this.itemLoanService.getItemLoanByLoanId(id);

        return this.getLoanById(id)
            .map(loan -> loan.calculateTotalFine(itemLoans))
            .orElseThrow(() -> new EntityNotFoundException("Loan not found"));
    }
    
}

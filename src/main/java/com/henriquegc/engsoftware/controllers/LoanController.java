package com.henriquegc.engsoftware.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.services.ILoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final ILoanService loanService;

    public LoanController(ILoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping()
    public List<Loan> getLoans() {
        return this.loanService.getLoans();
    }

    @PostMapping()
    public void createLoan(@RequestBody Loan Loan) {
        this.loanService.createLoan(Loan);
    }

}

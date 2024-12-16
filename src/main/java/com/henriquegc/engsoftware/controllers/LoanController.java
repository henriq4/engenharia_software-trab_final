package com.henriquegc.engsoftware.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquegc.engsoftware.dtos.loan.CreateLoanDTO;
import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.services.IItemLoanService;
import com.henriquegc.engsoftware.services.ILoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final ILoanService loanService;
    private final IItemLoanService itemLoanService;

    public LoanController(ILoanService loanService, IItemLoanService itemLoanService) {
        this.loanService = loanService;
        this.itemLoanService = itemLoanService;
    }

    @GetMapping()
    public List<Loan> getLoans() {
        return this.loanService.getLoans();
    }

    @GetMapping("/{loanId}/items")
    public List<ItemLoan> getItemsLoan(@PathVariable Long loanId) {
        return this.itemLoanService.getItemLoanByLoanId(loanId);
    }

    @PostMapping()
    public void createLoan(@RequestBody CreateLoanDTO Loan) {
        this.loanService.createLoan(Loan);
    }

}

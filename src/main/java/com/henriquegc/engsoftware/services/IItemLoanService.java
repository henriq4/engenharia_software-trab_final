package com.henriquegc.engsoftware.services;

import java.util.List;
import java.util.Optional;

import com.henriquegc.engsoftware.dtos.itemLoan.CreateItemLoanDTO;
import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.models.Loan;

public interface IItemLoanService {
    public List<ItemLoan> getItemLoan();
    public void createItemLoan(CreateItemLoanDTO itemLoan, Loan loan);
    public void createItemsLoanByLoan(List<CreateItemLoanDTO> itemsLoan, Loan loan);
    public Optional<ItemLoan> getItemLoanById(Long id);
    public List<ItemLoan> getItemLoanByLoanId(Long loanId);
}

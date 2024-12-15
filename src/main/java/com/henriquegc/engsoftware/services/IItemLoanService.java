package com.henriquegc.engsoftware.services;

import java.util.List;
import java.util.Optional;

import com.henriquegc.engsoftware.models.ItemLoan;

public interface IItemLoanService {
    List<ItemLoan> getItemLoan();
    public void createItemLoan(ItemLoan loan);
    public Optional<ItemLoan> getItemLoanById(Long id);
}

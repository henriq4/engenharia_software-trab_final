package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.repositories.ItemLoanRepository;
import com.henriquegc.engsoftware.services.IItemLoanService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ItemLoanServiceImpl implements IItemLoanService {
    private final ItemLoanRepository itemLoanRepository;
    
    public ItemLoanServiceImpl(ItemLoanRepository itemLoanRepository) {
        this.itemLoanRepository = itemLoanRepository;
    }

    @Override
    public List<ItemLoan> getItemLoan() {
        return this.itemLoanRepository.findAll();
    }


    @Override
    public void createItemLoan(ItemLoan loan) {
        this.itemLoanRepository.save(loan);
    }


    @Override
    public Optional<ItemLoan> getItemLoanById(Long id) {
        return this.itemLoanRepository.findById(id);
    }
    
}

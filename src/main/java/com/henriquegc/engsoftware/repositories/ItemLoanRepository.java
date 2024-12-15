package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.ItemLoan;

public interface ItemLoanRepository extends JpaRepository<ItemLoan, Long> {
    
}

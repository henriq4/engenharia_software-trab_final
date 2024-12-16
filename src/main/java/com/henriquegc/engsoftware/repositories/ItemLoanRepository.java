package com.henriquegc.engsoftware.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.ItemLoan;

public interface ItemLoanRepository extends JpaRepository<ItemLoan, Long> {
    List<ItemLoan> findByLoanId(Long loanId);
}

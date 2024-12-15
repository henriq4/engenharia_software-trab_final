package com.henriquegc.engsoftware.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.henriquegc.engsoftware.models.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    
}

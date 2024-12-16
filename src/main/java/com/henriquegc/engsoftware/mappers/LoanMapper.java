package com.henriquegc.engsoftware.mappers;

import com.henriquegc.engsoftware.dtos.loan.CreateLoanDTO;
import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.models.Student;

public class LoanMapper {
    public static Loan mapToLoan(CreateLoanDTO loan, Student student) {
        return Loan.builder()
            .finePerDay(loan.getFinePerDay())
            .student(student)
            .build();
    }
}
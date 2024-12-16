package com.henriquegc.engsoftware.dtos.loan;

import java.util.List;

import com.henriquegc.engsoftware.dtos.itemLoan.CreateItemLoanDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateLoanDTO {
    private double finePerDay;
    private Long studentId;
    private List<CreateItemLoanDTO> items;
}

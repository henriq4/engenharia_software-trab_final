package com.henriquegc.engsoftware.dtos.itemLoan;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateItemLoanDTO {
    private Long bookId;
    private LocalDate dateLoan;
    private LocalDate dateToReturn;
}

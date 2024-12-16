package com.henriquegc.engsoftware.mappers;

import com.henriquegc.engsoftware.dtos.itemLoan.CreateItemLoanDTO;
import com.henriquegc.engsoftware.models.Book;
import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.models.Loan;

public class ItemLoanMapper {
    public static ItemLoan mapToItemLoan(CreateItemLoanDTO itemLoan, Book book, Loan loan) {
        return ItemLoan.builder()
            .book(book)
            .loan(loan)
            .dateLoan(itemLoan.getDateLoan())
            .dateToReturn(itemLoan.getDateToReturn())
            .dateReturned(null)
            .build();
    }
}
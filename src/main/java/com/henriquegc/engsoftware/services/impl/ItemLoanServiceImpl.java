package com.henriquegc.engsoftware.services.impl;

import com.henriquegc.engsoftware.dtos.itemLoan.CreateItemLoanDTO;
import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.models.Loan;
import com.henriquegc.engsoftware.repositories.BookRepository;
import com.henriquegc.engsoftware.repositories.ItemLoanRepository;
import com.henriquegc.engsoftware.services.IItemLoanService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import static com.henriquegc.engsoftware.mappers.ItemLoanMapper.mapToItemLoan;

@Service
public class ItemLoanServiceImpl implements IItemLoanService {
    private final ItemLoanRepository itemLoanRepository;
    private final BookRepository bookRepository;
    
    public ItemLoanServiceImpl(ItemLoanRepository itemLoanRepository, BookRepository bookRepository) {
        this.itemLoanRepository = itemLoanRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<ItemLoan> getItemLoan() {
        return this.itemLoanRepository.findAll();
    }

    @Override
    public void createItemLoan(CreateItemLoanDTO itemLoan, Loan loan) {
        var book = this.bookRepository.findById(itemLoan.getBookId()).orElseThrow();

        this.itemLoanRepository.save(mapToItemLoan(itemLoan, book, loan));
    }

    @Override
    public Optional<ItemLoan> getItemLoanById(Long id) {
        return this.itemLoanRepository.findById(id);
    }

    @Override
    public List<ItemLoan> getItemLoanByLoanId(Long loanId) {
        return this.itemLoanRepository.findByLoanId(loanId);
    }

    @Override
    public void createItemsLoanByLoan(List<CreateItemLoanDTO> itemsLoan, Loan loan) {
        var items = itemsLoan.stream()
            .map(item -> {
                var book = this.bookRepository.findById(item.getBookId()).orElseThrow();
                return mapToItemLoan(item, book, loan);
            })
            .toList();

        this.itemLoanRepository.saveAll(items);
    }

}

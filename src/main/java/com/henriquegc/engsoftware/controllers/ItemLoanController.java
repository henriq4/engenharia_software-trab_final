package com.henriquegc.engsoftware.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquegc.engsoftware.models.ItemLoan;
import com.henriquegc.engsoftware.services.IItemLoanService;

@RestController
@RequestMapping("/items-loan")
public class ItemLoanController {
    private final IItemLoanService itemLoanService;

    public ItemLoanController(IItemLoanService itemLoanService) {
        this.itemLoanService = itemLoanService;
    }

    @GetMapping()
    public List<ItemLoan> getItemLoan() {
        return this.itemLoanService.getItemLoan();
    }

    @PostMapping()
    public void createItemLoan(@RequestBody ItemLoan ItemLoan) {
        this.itemLoanService.createItemLoan(ItemLoan);
    }

}

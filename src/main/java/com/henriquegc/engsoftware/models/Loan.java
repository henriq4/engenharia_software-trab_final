package com.henriquegc.engsoftware.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Student student;

    private double finePerDay;

    public double calculateTotalFine(List<ItemLoan> items) {
        double multaTotal = 0;
        for (ItemLoan item : items) {
            multaTotal += item.calculateDayOfDelay() * finePerDay;
        }
        return multaTotal;
    }

    public long calculateTotalDelayDay(List<ItemLoan> items) {
        return items.stream().mapToLong(ItemLoan::calculateDayOfDelay).sum();
    }
}

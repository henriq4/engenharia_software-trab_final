package com.henriquegc.engsoftware.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemLoan> items;

    private double finePerDay;

    public double calculateTotalFine() {
        double multaTotal = 0;
        for (ItemLoan item : items) {
            multaTotal += item.calculateDayOfDelay() * finePerDay;
        }
        return multaTotal;
    }

    public long calculateTotalDelayDay() {
        return items.stream().mapToLong(ItemLoan::calculateDayOfDelay).sum();
    }
}

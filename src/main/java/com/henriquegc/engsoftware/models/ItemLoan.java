package com.henriquegc.engsoftware.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
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
public class ItemLoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Book book;

    @ManyToOne(optional = false)
    private Loan loan;

    @Column(nullable = false)
    private LocalDate dateLoan;

    @Column(nullable = false)
    private LocalDate dateToReturn;

    @Column(nullable = true)
    private LocalDate dateReturned;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public long calculateDayOfDelay() {
        if (dateReturned != null && dateReturned.isAfter(dateToReturn)) {
            return ChronoUnit.DAYS.between(dateToReturn, dateReturned);
        }
        
        return 0;
    }
}

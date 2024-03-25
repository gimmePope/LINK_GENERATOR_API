package com.pocosoft.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Invoice {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private LocalDateTime issuedAt;
    private LocalDateTime dueDate;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status; 
    
    @ManyToOne
    private Company company;
    
    @ManyToOne
    private Customer customer;
    
	

}

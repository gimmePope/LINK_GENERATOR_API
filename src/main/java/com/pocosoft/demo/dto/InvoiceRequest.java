package com.pocosoft.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceRequest {
	
	private long customerId;
	private long companyId;
	private BigDecimal amount;
	private LocalDateTime issuedAt;
    private LocalDateTime dueDate;
	

}

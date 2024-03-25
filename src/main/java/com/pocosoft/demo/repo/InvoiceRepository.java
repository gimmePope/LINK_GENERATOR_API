package com.pocosoft.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocosoft.demo.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}

package com.pocosoft.demo.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pocosoft.demo.entities.Invoice;
import com.pocosoft.demo.exceptions.InvoiceNotFoundException;
import com.pocosoft.demo.repo.InvoiceRepository;

@Service
public class InvoiceService {
	
	 @Autowired
	 private InvoiceRepository invoiceRepository;
	 @Value("${service.domain}")
	 private String domain;

	    public Invoice createInvoice(Invoice invoice) {
	        return invoiceRepository.save(invoice);
	    }

	    public String generatePaymentLink(Long invoiceId) {
	    	Invoice invoice = getInvoiceById(invoiceId);
	        return domain + "invoices/" +invoice.getId();
	    }

		public  Invoice getInvoiceById(Long id) {
			// TODO Auto-generated method stub
			return invoiceRepository.findById(id).orElseThrow(() -> new InvoiceNotFoundException("Could not locate any invoice with specified id: " + id));
		}

}

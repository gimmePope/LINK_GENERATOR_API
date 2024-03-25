package com.pocosoft.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocosoft.demo.db.services.CompanyService;
import com.pocosoft.demo.db.services.CustomerService;
import com.pocosoft.demo.db.services.InvoiceService;
import com.pocosoft.demo.dto.InvoiceRequest;
import com.pocosoft.demo.entities.Company;
import com.pocosoft.demo.entities.Customer;
import com.pocosoft.demo.entities.Invoice;
import com.pocosoft.demo.entities.PaymentStatus;

@RestController
@RequestMapping(path = "/api/invoices")
public class InvoiceWebservice {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private InvoiceService invoiceService;
	
	
	@PostMapping("/create/invoice")
	public ResponseEntity<String> createInvoice(@RequestBody InvoiceRequest request)
	{
		long customerId = request.getCustomerId();
		long companyId = request.getCompanyId();
		
		Customer toCustomer = customerService.getCustomerById(customerId);
		Company fromCompany = companyService.getCompanyById(companyId);
		
		Invoice invoice = new Invoice();
		
		invoice.setCustomer(toCustomer);
		invoice.setCompany(fromCompany);
		invoice.setAmount(request.getAmount());
		invoice.setDueDate(request.getDueDate());
		invoice.setIssuedAt(request.getIssuedAt());
		invoice.setStatus(PaymentStatus.UNPAID);
		
		Invoice saved = invoiceService.createInvoice(invoice);
		
		if(saved != null)
			return new ResponseEntity<String>("Invoice created successfully, Invoice ID: " + saved.getId(), HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Invoice Creation Failed", HttpStatus.FAILED_DEPENDENCY);
		
	}
	
	@GetMapping("/generate/link/{invoiceId}")
	public String getInvoiceLink(@PathVariable("invoiceId") Long id)
	{
		String invoiceLink = invoiceService.generatePaymentLink(id);
		return invoiceLink;
	}

}

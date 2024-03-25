package com.pocosoft.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pocosoft.demo.db.services.InvoiceService;
import com.pocosoft.demo.entities.Invoice;

@Controller
public class InvoiceController {
	
	 @Autowired
	    private InvoiceService invoiceService;

	    // Endpoint to display the invoice details page
	    @GetMapping("/invoices/{id}")
	    public String viewInvoice(@PathVariable Long id, Model model) {
	        Invoice invoice = invoiceService.getInvoiceById(id);
	        model.addAttribute("invoice", invoice);
	        return "invoice"; 
	    }

	    // Endpoint to redirect to the payment page
	    @GetMapping("/pay/{id}")
	    public String paymentPage(@PathVariable Long id, Model model) {
	        model.addAttribute("invoiceId", id);
	        return "payment"; 
	    }

}

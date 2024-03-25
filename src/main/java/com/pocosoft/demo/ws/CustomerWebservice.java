package com.pocosoft.demo.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pocosoft.demo.db.services.CustomerService;
import com.pocosoft.demo.entities.Customer;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/customer")
public class CustomerWebservice {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/view/info/{customerId}")
	public ResponseEntity<Customer> getCustomerDetails(@PathVariable("customerId") Long id)
	{
		Customer inView = customerService.getCustomerById(id);
		
		return new ResponseEntity<Customer>(inView, HttpStatus.OK);
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer aCustomer, BindingResult bindResult)
	{
		System.out.println("ERRORS: " + bindResult.hasErrors());
		if (bindResult.hasErrors())
		{
			System.err.println("Error Found");
			return ResponseEntity.badRequest().body(bindResult.getFieldErrors().get(0).getDefaultMessage());
		}
		
		Customer savedCustomer = customerService.saveCustomerDetails(aCustomer);
		
		if(savedCustomer != null)
		{
			return new ResponseEntity<String> ("Customer Successfully Registered, customer ID: " + savedCustomer.getId(), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String> ("Customer Registration Failed", HttpStatus.FAILED_DEPENDENCY);
	}
	

}

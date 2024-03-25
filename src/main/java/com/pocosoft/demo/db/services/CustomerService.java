package com.pocosoft.demo.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocosoft.demo.exceptions.CustomerNotFoundException;
import com.pocosoft.demo.entities.Customer;
import com.pocosoft.demo.repo.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer saveCustomerDetails(Customer aCustomer)
	{
		return customerRepository.save(aCustomer);
	}
	
	public Customer getCustomerById(Long id)
	{
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("No customer found with Id: " + id));
	}

}

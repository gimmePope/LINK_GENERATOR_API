package com.pocosoft.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import com.pocosoft.demo.db.services.CompanyService;
import com.pocosoft.demo.db.services.CustomerService;
import com.pocosoft.demo.entities.Company;
import com.pocosoft.demo.entities.Customer;

@SpringBootApplication
public class LinkGeneratorApiApplication {
	
	
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CompanyService companyService;
	

	public static void main(String[] args) {
		SpringApplication.run(LinkGeneratorApiApplication.class, args);
	}
	
	
	@Bean
	@ConditionalOnProperty(name = "app.run-command-line", havingValue = "true")
	CommandLineRunner runner()
	{
		// pre-populating medication and drones table
		return args ->
		{
			Customer customer1 = new Customer();
			Customer customer2 = new Customer();
			
			customer1.setEmail("service@ABCbankng.com");
			customer1.setName("ABC Bank");
			customer2.setEmail("diamond@testmail.com");
			customer2.setName("Diamond Enterprise");
			customerService.saveCustomerDetails(customer1);
			customerService.saveCustomerDetails(customer2);
			
			Company company1 = new Company();
			Company company2 = new Company();
			
			company1.setName("GOLDBRIDGE FINANCIAL CONSULT");
			company1.setAddress("12 Obalende road, Marina, Lagos");
			company1.setPhone("09077189090");
			company2.setName("ABEL CEMENTS");
			company2.setAddress("1 Salami Esatate, Ikorodu, Lagos");
			company2.setPhone("09032324412");
			companyService.saveCompany(company1);
			companyService.saveCompany(company2);
			
			
		};
	}
		

}

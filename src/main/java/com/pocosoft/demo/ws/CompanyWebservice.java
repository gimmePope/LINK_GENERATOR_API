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

import com.pocosoft.demo.db.services.CompanyService;
import com.pocosoft.demo.entities.Company;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/company")
public class CompanyWebservice {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerNewCompany(@Valid @RequestBody Company aCompany, BindingResult bindResult)
	{
		System.out.println("ERRORS: " + bindResult.hasErrors());
		if (bindResult.hasErrors())
		{
			System.err.println("Error Found");
			return ResponseEntity.badRequest().body(bindResult.getFieldErrors().get(0).getDefaultMessage());
		}
		
		Company savedCompany = companyService.saveCompany(aCompany);
		
		if (savedCompany != null)
		{
			return new ResponseEntity<String> ("Company Successfully Registered, company ID: " + savedCompany.getId(), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<String> ("Company Registration Failed", HttpStatus.FAILED_DEPENDENCY);
		
	}
	
	
	@GetMapping("/view/info/{companyId}")
	public ResponseEntity<Company> getCompanyInfoById(@PathVariable("companyId") long id)
	{
		Company companyInview = companyService.getCompanyById(id);
		
		return new ResponseEntity<Company>(companyInview, HttpStatus.OK);
			
			
	}
	
	
	
	
}

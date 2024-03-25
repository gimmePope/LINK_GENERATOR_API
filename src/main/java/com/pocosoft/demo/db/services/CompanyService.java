package com.pocosoft.demo.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pocosoft.demo.entities.Company;
import com.pocosoft.demo.exceptions.CompanyNotFoundException;
import com.pocosoft.demo.repo.CompanyRepository;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Company saveCompany(Company company)
	{
		return companyRepository.save(company);
	}
	
	public Company getCompanyById(Long id)
	{
		return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException("Invalid Company ID"));
	}
	
	

}

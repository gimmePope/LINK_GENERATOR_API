package com.pocosoft.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pocosoft.demo.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

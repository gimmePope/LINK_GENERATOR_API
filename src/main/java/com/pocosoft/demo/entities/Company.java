package com.pocosoft.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Company {
	
	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @NotEmpty(message = "Company name cannot be null")
	 private String name;
	 private String address;
	 private String phone;

}

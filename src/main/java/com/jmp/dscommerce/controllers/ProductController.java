package com.jmp.dscommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dscommerce.dtos.ProductDto;
import com.jmp.dscommerce.services.ProductService;

@RestController
@RequestMapping(value="/products") 
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping(value="/{id}")
	public ProductDto buscarId(@PathVariable Long id) {
		ProductDto dto =  service.findById(id);
		
		return dto;
		
	}
}

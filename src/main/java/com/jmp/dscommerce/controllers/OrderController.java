package com.jmp.dscommerce.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dscommerce.dtos.CarrinhoOrderDto;
import com.jmp.dscommerce.services.OrderService;

@RestController
@RequestMapping(value="/orders") 
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value="/{id}")
	public ResponseEntity<CarrinhoOrderDto> findById(@PathVariable Long id) {
		CarrinhoOrderDto dto =  service.findById(id);
		
		return ResponseEntity.ok(dto);		
	}
}

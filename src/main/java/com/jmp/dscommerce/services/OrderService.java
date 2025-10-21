package com.jmp.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.dscommerce.dtos.CarrinhoOrderDto;
import com.jmp.dscommerce.entities.Order;
import com.jmp.dscommerce.repositories.OrderRepository;
import com.jmp.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	public CarrinhoOrderDto findById(Long id) {
		Order order = repository.findById(id)
			.orElseThrow(() -> new
			ResourceNotFoundException("Recurso nao encontrado"));
		
		return new CarrinhoOrderDto(order);
	}
	
}

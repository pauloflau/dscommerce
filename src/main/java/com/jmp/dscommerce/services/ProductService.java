package com.jmp.dscommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.dscommerce.dtos.ProductDto;
import com.jmp.dscommerce.entities.Product;
import com.jmp.dscommerce.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly=true)
	public ProductDto findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		
		ProductDto dto = new ProductDto(product);
		
		return dto;
	}
}

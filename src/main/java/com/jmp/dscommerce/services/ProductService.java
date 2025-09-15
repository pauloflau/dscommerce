package com.jmp.dscommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.dscommerce.dtos.ProductDto;
import com.jmp.dscommerce.entities.Product;
import com.jmp.dscommerce.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	@Transactional(readOnly = true)
	public Page<ProductDto> findAll(Pageable pageable) {
		Page<Product> result = repository.findAll(pageable);
		List<ProductDto> dto = new ArrayList<>();
		
		for (Product item : result) {
			ProductDto produtoDto = new ProductDto(item);
			dto.add(produtoDto);
		}
		return new PageImpl<>(dto, pageable, result.getTotalElements());
	}
	
	@Transactional(readOnly=true)
	public ProductDto findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		
		ProductDto dto = new ProductDto(product);
		
		return dto;
	}
}

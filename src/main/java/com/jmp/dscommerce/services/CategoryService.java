package com.jmp.dscommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmp.dscommerce.dtos.CategoryDto;
import com.jmp.dscommerce.entities.Category;
import com.jmp.dscommerce.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDto> findAll(){
		List<Category> result = repository.findAll();
		List<CategoryDto> dtos = new ArrayList<>();
		
		for(Category cat : result) {
			dtos.add(new CategoryDto(cat));
		}
		
		return dtos;
	}
}

package com.jmp.dscommerce.controllers.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jmp.dscommerce.dtos.CategoryDto;
import com.jmp.dscommerce.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> findAll(){
		List<CategoryDto> result = service.findAll();
		return ResponseEntity.ok(result);
	}
}

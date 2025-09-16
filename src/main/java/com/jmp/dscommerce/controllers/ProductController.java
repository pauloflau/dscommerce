package com.jmp.dscommerce.controllers;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jmp.dscommerce.dtos.ProductDto;
import com.jmp.dscommerce.services.ProductService;

@RestController
@RequestMapping(value="/products") 
public class ProductController {

	@Autowired
	ProductService service;
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<ProductDto> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();		
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);		
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> insert(@RequestBody ProductDto dto) {
		dto = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(dto);
	}
	
	
	@GetMapping
	public ResponseEntity<Page<ProductDto>> findAll(Pageable pageable){
		return ResponseEntity.ok(service.findAll(pageable));
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable Long id) {
		ProductDto dto =  service.findById(id);
		
		return ResponseEntity.ok(dto);		
	}
}

package com.jmp.dscommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.dscommerce.dtos.CategoryDto;
import com.jmp.dscommerce.dtos.ProductDto;
import com.jmp.dscommerce.dtos.ProductMinDto;
import com.jmp.dscommerce.entities.Category;
import com.jmp.dscommerce.entities.Product;
import com.jmp.dscommerce.repositories.ProductRepository;
import com.jmp.dscommerce.services.exceptions.DatabaseException;
import com.jmp.dscommerce.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Page<ProductMinDto> findAll(String name, Pageable pageable){
		Page<Product> result;
		if(name==null || name.isEmpty()) {
			result = repository.findAll(pageable);
		}else {
			result = repository.searchByName(name, pageable);
		}
		return result.map(ProductMinDto::new);
	}

	@Transactional(propagation = Propagation.SUPPORTS)	
	public void delete(Long id) {
		if(!repository.existsById(id)) {
			throw new ResourceNotFoundException("Recurso nao encontrado.");
		}
		try {
			repository.deleteById(id);			
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Falha de integridade referencial.");
		}		
	}
	
	@Transactional
	public ProductDto update(Long id, ProductDto dto) {
		try {
		Product entity = repository.getReferenceById(id);
		copyDtoToEntity(dto, entity);		
		entity = repository.save(entity);
		
		return 	new ProductDto(entity);
		
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Recurso nao encontrado");
		}
	}
	
	
	@Transactional
	public ProductDto insert(ProductDto dto) {

		
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		 entity = repository.findById(entity.getId())
		            .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));

		
		return 	new ProductDto(entity);		
	}
	
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
		Product product = repository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Recurso nao encontrado"));
		
		ProductDto dto = new ProductDto(product);
		
		return dto;
	}
	
	private void copyDtoToEntity(ProductDto dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl()); 
		
		//entity.getCategories().clear();
		for(CategoryDto catDto : dto.getCategories()) {
			Category cat = entityManager.getReference(Category.class, catDto.getId());
			entity.getCategories().add(cat);
		}
	}
}

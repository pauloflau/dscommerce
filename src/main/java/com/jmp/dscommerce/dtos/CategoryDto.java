package com.jmp.dscommerce.dtos;

import com.jmp.dscommerce.entities.Category;

public class CategoryDto {
	private Long id;
	private String name;

	public CategoryDto() {
	}

	public CategoryDto(Long id, String nome) {
		this.id = id;
		this.name = nome;
	}

	public CategoryDto(Category entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

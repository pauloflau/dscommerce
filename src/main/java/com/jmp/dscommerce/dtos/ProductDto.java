package com.jmp.dscommerce.dtos;

import java.util.ArrayList;
import java.util.List;

import com.jmp.dscommerce.entities.Category;
import com.jmp.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDto {

	private Long id;

	@NotBlank(message = "campo requerido")
	@Size(min = 3, max = 80, message = "campo deve ter entre 3 e 80 caracteres")
	private String name;

	@NotBlank(message = "campo requerido")
	@Size(min = 10, message = "campo deve ter no minimo 10 caracteres")
	private String description;

	@NotNull(message = "campo requerido")
	@Positive(message = "o campo deve ser positivo")
	private Double price;
	private String imgUrl;

	@NotEmpty(message = "Deve ter pelo menos uma categoria")
	private List<CategoryDto> categories = new ArrayList<>();

	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductDto(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductDto(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
		for (Category cat : entity.getCategories()) {
			categories.add(new CategoryDto(cat));
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public List<CategoryDto> getCategories() {
		return categories;
	}
}

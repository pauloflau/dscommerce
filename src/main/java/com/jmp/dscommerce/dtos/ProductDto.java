package com.jmp.dscommerce.dtos;

import com.jmp.dscommerce.entities.Product;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
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
	
	
	
}

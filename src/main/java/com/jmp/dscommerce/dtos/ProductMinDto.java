package com.jmp.dscommerce.dtos;

import com.jmp.dscommerce.entities.Product;

public class ProductMinDto {
	private Long id;
	private String name;
	private Double price;
	private String imgUrl;

	public ProductMinDto() {
		// TODO Auto-generated constructor stub
	}

	public ProductMinDto(Long id, String name, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public ProductMinDto(Product entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.price = entity.getPrice();
		this.imgUrl = entity.getImgUrl();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}

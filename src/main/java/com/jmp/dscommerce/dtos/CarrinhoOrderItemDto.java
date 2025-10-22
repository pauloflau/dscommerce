package com.jmp.dscommerce.dtos;

import com.jmp.dscommerce.entities.OrderItem;

public class CarrinhoOrderItemDto {
	private Long productId;
	private String name;
	private Double price;
	private Integer quantity;
	private String imgUrl;
	
	public CarrinhoOrderItemDto() {
		// TODO Auto-generated constructor stub
	}

	public CarrinhoOrderItemDto(Long productId, String name, Double price, Integer quantity, String imgUrl) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.imgUrl = imgUrl;
	}

	public CarrinhoOrderItemDto(OrderItem entity) {
		productId = entity.getProduct().getId();
		name = entity.getProduct().getName();
		price = entity.getPrice();
		quantity = entity.getQuantity();
		imgUrl = entity.getProduct().getImgUrl();
	}

	public Long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
}

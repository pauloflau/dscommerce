package com.jmp.dscommerce.dtos;

import com.jmp.dscommerce.entities.User;

public class CarrinhoClientDto {
	private Long id;
	private String name;

	public CarrinhoClientDto() {
		// TODO Auto-generated constructor stub
	}

	public CarrinhoClientDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CarrinhoClientDto(User entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

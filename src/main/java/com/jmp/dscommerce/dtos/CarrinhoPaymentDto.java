package com.jmp.dscommerce.dtos;

import java.time.Instant;

import com.jmp.dscommerce.entities.Payment;

public class CarrinhoPaymentDto {
	private Long id;
	private Instant moment;
	
	public CarrinhoPaymentDto() {
		// TODO Auto-generated constructor stub
	}

	public CarrinhoPaymentDto(Long id, Instant moment) {
		this.id = id;
		this.moment = moment;
	}

	public CarrinhoPaymentDto(Payment entity) {
		id = entity.getId();
		moment = entity.getMoment();
	}

	public Long getId() {
		return id;
	}

	public Instant getMoment() {
		return moment;
	}
}

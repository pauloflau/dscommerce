package com.jmp.dscommerce.dtos;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.jmp.dscommerce.entities.Order;
import com.jmp.dscommerce.entities.OrderItem;
import com.jmp.dscommerce.entities.OrderStatus;

import jakarta.validation.constraints.NotEmpty;

public class CarrinhoOrderDto {

	private Long id;
	private Instant moment;
	private OrderStatus status;
	
	private CarrinhoClientDto client;
	
	private CarrinhoPaymentDto payment;
	
	@NotEmpty(message = "Deve ter pelo menos um item")
	private List<CarrinhoOrderItemDto> items = new ArrayList<>();
	
	public CarrinhoOrderDto() {
		// TODO Auto-generated constructor stub
	}

	public CarrinhoOrderDto(Long id, Instant moment, OrderStatus status, CarrinhoClientDto client,
			CarrinhoPaymentDto payment) {
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}

	public CarrinhoOrderDto(Order entity) {
		id = entity.getId();
		moment = entity.getMoment();
		status = entity.getStatus();
		client = new CarrinhoClientDto(entity.getClient());
		payment = (entity.getPayment() == null) ? null : new CarrinhoPaymentDto(entity.getPayment());
		
		for(OrderItem item : entity.getItems()) {
			CarrinhoOrderItemDto itemDto = new CarrinhoOrderItemDto(item);
			items.add(itemDto);
		}
	}
	
	public Double getTotal() {
		double soma = 0.0;
		for(CarrinhoOrderItemDto item : items) {
			soma = soma + item.getSubTotal();
		}
		return soma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public CarrinhoClientDto getClient() {
		return client;
	}

	public void setClient(CarrinhoClientDto client) {
		this.client = client;
	}

	public CarrinhoPaymentDto getPayment() {
		return payment;
	}

	public void setPayment(CarrinhoPaymentDto payment) {
		this.payment = payment;
	}

	public List<CarrinhoOrderItemDto> getItems() {
		return items;
	}

	public void setItems(List<CarrinhoOrderItemDto> items) {
		this.items = items;
	}
	
	
	
}

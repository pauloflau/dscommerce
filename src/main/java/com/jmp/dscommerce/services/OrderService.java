package com.jmp.dscommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jmp.dscommerce.dtos.CarrinhoOrderDto;
import com.jmp.dscommerce.dtos.CarrinhoOrderItemDto;
import com.jmp.dscommerce.entities.Order;
import com.jmp.dscommerce.entities.OrderItem;
import com.jmp.dscommerce.entities.OrderStatus;
import com.jmp.dscommerce.entities.Product;
import com.jmp.dscommerce.entities.User;
import com.jmp.dscommerce.repositories.OrderItemRepository;
import com.jmp.dscommerce.repositories.OrderRepository;
import com.jmp.dscommerce.repositories.ProductRepository;
import com.jmp.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository produtoRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserService userService;
	
	public CarrinhoOrderDto findById(Long id) {
		Order order = repository.findById(id)
			.orElseThrow(() -> new
			ResourceNotFoundException("Recurso nao encontrado"));
		
		return new CarrinhoOrderDto(order);
	}
	
	@Transactional
	public CarrinhoOrderDto insert(CarrinhoOrderDto dto) {
		
		Order order = new Order(); 
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user = userService.authenticated();
		
		order.setClient(user);

		for(CarrinhoOrderItemDto orderItemDto : dto.getItems()) {
			Product product = produtoRepository.getReferenceById (orderItemDto.getProductId());
			OrderItem item = new OrderItem(order, product, orderItemDto.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}

		repository.save(order);
		
		orderItemRepository.saveAll(order.getItems());
		
		return new CarrinhoOrderDto(order);
	}
}

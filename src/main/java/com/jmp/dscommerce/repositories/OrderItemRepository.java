package com.jmp.dscommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jmp.dscommerce.entities.OrderItem;
import com.jmp.dscommerce.entities.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}

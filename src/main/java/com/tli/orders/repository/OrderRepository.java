package com.tli.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tli.orders.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Integer> {
}

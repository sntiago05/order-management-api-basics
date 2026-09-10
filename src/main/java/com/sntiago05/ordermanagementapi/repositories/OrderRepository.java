package com.sntiago05.ordermanagementapi.repositories;

import com.sntiago05.ordermanagementapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

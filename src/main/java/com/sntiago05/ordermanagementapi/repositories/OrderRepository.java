package com.sntiago05.ordermanagementapi.repositories;

import com.sntiago05.ordermanagementapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
            SELECT DISTINCT o
            FROM Order o
            JOIN FETCH o.customer
            JOIN FETCH o.items i
            JOIN FETCH i.product
            """)
    List<Order> findAllOrdersWithItemsAndProducts();
}

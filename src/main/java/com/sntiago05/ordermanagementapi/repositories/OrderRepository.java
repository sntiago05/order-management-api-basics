package com.sntiago05.ordermanagementapi.repositories;

import com.sntiago05.ordermanagementapi.dto.OrderSummaryResponse;
import com.sntiago05.ordermanagementapi.entities.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    /*
    *
    @Query("""
            SELECT DISTINCT o
            FROM Order o
            JOIN FETCH o.customer
            JOIN FETCH o.items i
            JOIN FETCH i.product
            """)*/
    @EntityGraph(attributePaths = {
        "customer",
        "items",
        "items.product"
})
    @Query("SELECT o FROM Order o")
    List<Order> findAllOrdersWithItemsAndProducts();


    @Query("""
            SELECT new com.sntiago05.ordermanagementapi.dto.OrderSummaryResponse(
            o.orderId,
            c.email,
            o.createdAt,
            o.total)from Order o JOIN o.customer c
            """)
    List<OrderSummaryResponse> findAllOrdersHeaders();
}

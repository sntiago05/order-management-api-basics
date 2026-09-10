package com.sntiago05.ordermanagementapi.dto;

import com.sntiago05.ordermanagementapi.entities.OrderItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderResponse(
        Long orderid,
        String customerName,
        LocalDateTime createdAt,
        List<OrderItemResponse> items,
        BigDecimal total
) {
}

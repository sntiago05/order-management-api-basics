package com.sntiago05.ordermanagementapi.mapper;

import com.sntiago05.ordermanagementapi.dto.OrderItemResponse;
import com.sntiago05.ordermanagementapi.entities.OrderItem;

public class OrderItemMapper {
    private OrderItemMapper() {
    }

    public static OrderItemResponse toResponse(OrderItem orderItem) {
        return new OrderItemResponse(orderItem.getProduct().getName(), orderItem.getQuantity(), orderItem.getUnitPrice(), orderItem.getSubTotal());
    }
}

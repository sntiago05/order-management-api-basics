package com.sntiago05.ordermanagementapi.mapper;

import com.sntiago05.ordermanagementapi.dto.OrderResponse;
import com.sntiago05.ordermanagementapi.entities.Order;

public class OrderMapper
{
    private  OrderMapper()
    {
    }

    public static OrderResponse toResponse(Order order){
        return new OrderResponse(order.getOrderId(), order.getCustomer().getName(), order.getCreatedAt(),
                order.getItems().stream().map(OrderItemMapper::toResponse).toList(),order.getTotal());
    }
}

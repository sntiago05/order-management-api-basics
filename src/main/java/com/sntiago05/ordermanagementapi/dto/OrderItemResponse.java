package com.sntiago05.ordermanagementapi.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String productName,
        Integer quantity,
        BigDecimal unit_price,
        BigDecimal subTotal
) {
}

package com.sntiago05.ordermanagementapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record OrderItemRequest(@Positive Long productId,
                               @Positive Integer quantity) {
}

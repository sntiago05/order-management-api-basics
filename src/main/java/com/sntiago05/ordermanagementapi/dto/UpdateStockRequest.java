package com.sntiago05.ordermanagementapi.dto;

import jakarta.validation.constraints.Positive;

public record UpdateStockRequest(
        @Positive
        Integer stock
) {
}

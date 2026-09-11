package com.sntiago05.ordermanagementapi.dto;

public record UpdateStockResponse(
        Integer newStock,
        Long version
) {
}

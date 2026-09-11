package com.sntiago05.ordermanagementapi.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderSummaryResponse(Long orderId, String customerEmail, LocalDateTime createdAt, BigDecimal total) {
}

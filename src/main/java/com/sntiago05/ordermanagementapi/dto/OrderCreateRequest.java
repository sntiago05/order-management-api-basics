package com.sntiago05.ordermanagementapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.util.List;

public record OrderCreateRequest(@Positive Long CustomerId,
                                 @NotEmpty List<OrderItemRequest> orderItemRequests) {

}

package com.sntiago05.ordermanagementapi.mapper;

import com.sntiago05.ordermanagementapi.dto.UpdateStockResponse;
import com.sntiago05.ordermanagementapi.entities.Product;

public class ProductMapper {
    private  ProductMapper() {}
    public static UpdateStockResponse toResponse(Product product) {
        return new UpdateStockResponse(product.getStock(), product.getVersion());
    }
}

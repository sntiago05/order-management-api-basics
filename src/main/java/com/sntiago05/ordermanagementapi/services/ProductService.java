package com.sntiago05.ordermanagementapi.services;

import com.sntiago05.ordermanagementapi.dto.UpdateStockRequest;
import com.sntiago05.ordermanagementapi.dto.UpdateStockResponse;
import com.sntiago05.ordermanagementapi.entities.Product;
import com.sntiago05.ordermanagementapi.mapper.ProductMapper;
import com.sntiago05.ordermanagementapi.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public UpdateStockResponse updateStock(UpdateStockRequest updateStockRequest, Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(updateStockRequest.stock());
        productRepository.flush();
        return ProductMapper.toResponse(product);
    }
}

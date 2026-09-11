package com.sntiago05.ordermanagementapi.controller;

import com.sntiago05.ordermanagementapi.dto.UpdateStockRequest;
import com.sntiago05.ordermanagementapi.dto.UpdateStockResponse;
import com.sntiago05.ordermanagementapi.services.ProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class ProductController {
    private final ProductService productService;

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateStockResponse> updateStock(@Valid @RequestBody UpdateStockRequest request, @Positive(message = "id must be greater than 0") @PathVariable long id) {
        return ResponseEntity.ok(productService.updateStock(request, id));
    }

}

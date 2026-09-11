package com.sntiago05.ordermanagementapi.services;

import com.sntiago05.ordermanagementapi.dto.OrderCreateRequest;
import com.sntiago05.ordermanagementapi.dto.OrderResponse;
import com.sntiago05.ordermanagementapi.entities.Customer;
import com.sntiago05.ordermanagementapi.entities.Order;
import com.sntiago05.ordermanagementapi.entities.OrderItem;
import com.sntiago05.ordermanagementapi.entities.Product;
import com.sntiago05.ordermanagementapi.mapper.OrderMapper;
import com.sntiago05.ordermanagementapi.repositories.OrderRepository;
import com.sntiago05.ordermanagementapi.repositories.ProductRepository;
import com.sntiago05.ordermanagementapi.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public OrderResponse createOrder(OrderCreateRequest orderCreateRequest) {
        Customer customer = getCustomer(orderCreateRequest);

        Order order = Order.builder().createdAt(LocalDateTime.now()).customer(customer).items(new ArrayList<>()).build();
        orderCreateRequest.orderItemRequests().forEach(r -> {
                    Product product = tryToDecreaseStock(r.productId(), r.quantity());
                    order.getItems().add(OrderItem.builder()
                            .order(order)
                            .unitPrice(product.getPrice())
                            .quantity(r.quantity())
                            .product(product)
                            .subTotal(product.getPrice().multiply(BigDecimal.valueOf(r.quantity())))
                            .build());
                }
        );
        order.setTotal(order.getItems().stream().map(OrderItem::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add));
        return OrderMapper.toResponse(orderRepository.save(order));
    }


    public List<OrderResponse> findAllOrders() {
        return orderRepository.findAllOrdersWithItemsAndProducts().stream().map(OrderMapper::toResponse).toList();
    }


    private Customer getCustomer(OrderCreateRequest orderCreateRequest) {
        return customerRepository.findById(orderCreateRequest.CustomerId()).orElseThrow(() -> new RuntimeException("Customer not found"));
    }


    private Product tryToDecreaseStock(Long productId, Integer quantity) {
        Product product = productRepository.findByIdForUpdate(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getStock() < quantity) throw new RuntimeException("Stock exceeded");
        product.setStock(product.getStock() - quantity);
        return product;
    }


}

package com.ecommerce.order.order;

import com.ecommerce.order.enums.PaymentMethod;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderMapper {

    public Order toOrder(@Valid OrderRequest orderRequest) {
        return Order.builder()
                .id(orderRequest.getId())
                .reference(orderRequest.getReference())
                .createdAt(LocalDateTime.now())
                .customerId(orderRequest.getCustomerId())
                .paymentMethod(orderRequest.getPaymentMethod())
                .totalAmount(orderRequest.getAmount())
                .build();
    }
}

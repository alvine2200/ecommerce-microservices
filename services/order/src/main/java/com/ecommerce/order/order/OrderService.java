package com.ecommerce.order.order;

import com.ecommerce.order.http.CustomerClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClientService customerClientService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public Long placeOrder(@Valid OrderRequest orderRequest) {
        //check the customer

        //purchase the products

        //persists order

        //persist order-lines

        //start payment processing

        //send order confirmation notifications (kafka-ms)
        return null;
    }
}

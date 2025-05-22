package com.ecommerce.order.order;

import com.ecommerce.order.exceptions.BusinessException;
import com.ecommerce.order.http.CustomerClientService;
import com.ecommerce.order.http.ProductClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClientService customerClientService;
    private final ProductClientService productClientService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public Long placeOrder(@Valid OrderRequest orderRequest) {
        var customer = this.customerClientService.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(()-> new BusinessException("Cannot Create Order :: No Customer found with id " + orderRequest.getCustomerId()));

        //purchase the products
        this.productClientService.purchaseProducts(orderRequest.getProducts());

        //persists order

        //persist order-lines

        //start payment processing

        //send order confirmation notifications (kafka-ms)
        return null;
    }
}

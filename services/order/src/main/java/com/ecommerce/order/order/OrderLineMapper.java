package com.ecommerce.order.order;

import com.ecommerce.order.orderline.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest orderLineRequest){
        return OrderLine.builder()
                .quantity(orderLineRequest.getQuantity())
                .id(orderLineRequest.getId())
                .order(Order.builder().id(orderLineRequest.getOrderId()).build())
                .productId(orderLineRequest.getProductId())
                .build();
    }
}

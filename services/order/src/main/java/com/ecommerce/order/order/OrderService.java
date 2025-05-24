package com.ecommerce.order.order;

import com.ecommerce.order.exceptions.BusinessException;
import com.ecommerce.order.http.CustomerClientService;
import com.ecommerce.order.http.ProductClientService;
import com.ecommerce.order.kafka.OrderConfirmation;
import com.ecommerce.order.kafka.OrderProducer;
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
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Long placeOrder(@Valid OrderRequest orderRequest) {
        var customer = this.customerClientService.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(()-> new BusinessException("Cannot Create Order :: No Customer found with id " + orderRequest.getCustomerId()));
        var purchasedProducts = this.productClientService.purchaseProducts(orderRequest.getProducts());

        var order = orderRepository.save(orderMapper.toOrder(orderRequest));

        for (PurchaseRequest purchaseRequest : orderRequest.getProducts()){
            Long orderLineId = orderLineService.saveOrderLine(
                    new OrderLineRequest(
                           null,
                           order.getId(),
                           purchaseRequest.getProductId(),
                           purchaseRequest.getQuantity()
                    )
            );
        }

        //start payment processing

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.getReference(),
                        orderRequest.getAmount(),
                        orderRequest.getPaymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }
}

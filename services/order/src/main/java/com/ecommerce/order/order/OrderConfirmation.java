package com.ecommerce.order.order;

import com.ecommerce.order.customer.CustomerResponse;
import com.ecommerce.order.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmation {
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customer;
    List<PurchaseResponse> products;
}

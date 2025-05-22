package com.ecommerce.order.order;

import com.ecommerce.order.enums.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderRequest {
    private Long id;
    private String reference;
    @Positive(message = "Order Amount should be positive")
    private BigDecimal amount;
    @NotNull(message = "payment method is required")
    private PaymentMethod paymentMethod;
    @NotNull(message = "customer's id is required")
    private String customerId;
    @NotEmpty(message = "products list is required")
    private List<PurchaseRequest> products;
}

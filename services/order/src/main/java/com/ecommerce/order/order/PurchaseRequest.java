package com.ecommerce.order.order;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseRequest {
    @NotNull(message = "product id is required")
    private Long productId;
    @Positive(message = "quantity should be a positive integer")
    @NotNull(message = "quantity is required")
    private Double quantity;
}

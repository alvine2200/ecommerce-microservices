package com.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductPurchaseRequest {
    @NotNull(message = "quantity is required")
    private Double quantity;
    @NotNull(message = "product id is required")
    private Long productId;
}

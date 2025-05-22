package com.ecommerce.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductPurchaseResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Double quantity;
}

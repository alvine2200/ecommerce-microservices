package com.ecommerce.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Long categoryId;
    private String categoryName;
    private String categoryDescription;
    private BigDecimal price;
    private Double availableQuantity;
}

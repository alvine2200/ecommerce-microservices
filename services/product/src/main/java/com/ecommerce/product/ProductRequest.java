package com.ecommerce.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequest {
    private Long id;
    @NotNull(message = "name is required")
    private String name;
    @NotNull(message = "description is required")
    private String description;
    @NotNull(message = "Category id is required")
    private Long categoryId;
    @NotNull(message = "price is required")
    @Positive(message = "Price should be a positive number")
    private Double price;
    @NotNull(message = "product quantity is required")
    @Positive(message = "Quantity should be a positive number")
    private Double availableQuantity;
}

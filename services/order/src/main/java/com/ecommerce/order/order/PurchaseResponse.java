package com.ecommerce.order.order;

import java.math.BigDecimal;

public record PurchaseResponse(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        Double quantity
) {
}

package com.ecommerce.product;

import com.ecommerce.category.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest){
        return Product.builder()
                .name(productRequest.getName())
                .price(BigDecimal.valueOf(productRequest.getPrice()))
                .availableQuantity(productRequest.getAvailableQuantity())
                .description(productRequest.getDescription())
                .category(Category.builder()
                        .id(productRequest.getId())
                        .build())
                .build();
    }


    public ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .availableQuantity(product.getAvailableQuantity())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, @NotNull(message = "quantity is required") Double quantity) {
        return ProductPurchaseResponse.builder()
                .productId(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(quantity)

                .build();
    }
}

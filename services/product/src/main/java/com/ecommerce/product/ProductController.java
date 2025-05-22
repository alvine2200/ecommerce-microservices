package com.ecommerce.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody @Valid ProductRequest productRequest){
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchase(@RequestBody @Valid List<ProductPurchaseRequest> productPurchaseRequests){
        return ResponseEntity.ok(productService.purchaseProduct(productPurchaseRequests));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> allProducts(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable(name = "product-id",required = true) Long productId){
        return ResponseEntity.ok(productService.findProductDetails(productId));
    }
}

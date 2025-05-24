package com.ecommerce.product;

import com.ecommerce.exceptions.ProductNotFoundException;
import com.ecommerce.exceptions.ProductPurchaseException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public Long createProduct(@Valid ProductRequest productRequest) {
        return productRepository.save(productMapper.toProduct(productRequest)).getId();
    }

    public List<ProductPurchaseResponse> purchaseProduct(@Valid List<ProductPurchaseRequest> productPurchaseRequests) {
        var productIds = productPurchaseRequests.stream()
                .map(ProductPurchaseRequest::getProductId)
                .toList();
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        if (productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One Or More products do not exists");
        }

        var storedRequests = productPurchaseRequests
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::getProductId))
                .toList();

        var purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequests.get(i);

            if (product.getAvailableQuantity() < productRequest.getQuantity()){
                throw new ProductPurchaseException("Available Stock Quantity for product is less than the requested quantity for " + product.getName());
            }

            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.getQuantity();

            product.setAvailableQuantity(newAvailableQuantity);
            productRepository.save(product);

            purchasedProducts.add(productMapper.toProductPurchaseResponse(product,productRequest.getQuantity()));
        }

        return purchasedProducts;
    }

    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse findProductDetails(Long productId) {
        return productRepository.findById(productId)
                .map(productMapper::toProductResponse)
                .orElseThrow(()->new ProductNotFoundException("Product Not Found"));
    }
}

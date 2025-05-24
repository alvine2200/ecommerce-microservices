package com.ecommerce.order.http;

import com.ecommerce.order.order.PurchaseResponse;
import com.ecommerce.order.exceptions.BusinessException;
import com.ecommerce.order.order.PurchaseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClientService {

    @Value("${application.config.product-url}")
    public String productUrl;

    private final RestTemplate restTemplate;

    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> requestBody){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requestBody,httpHeaders);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>(){};
        ResponseEntity<List<PurchaseResponse>> responseEntity = restTemplate.exchange(
                productUrl+ "/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType
        );
        if (responseEntity.getStatusCode().isError()){
            throw new BusinessException("Unexpected Error occurred while purchasing products " + responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }
}

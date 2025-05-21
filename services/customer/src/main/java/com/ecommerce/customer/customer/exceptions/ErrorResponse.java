package com.ecommerce.customer.customer.exceptions;

import lombok.Builder;

import java.util.Map;

@Builder
public class ErrorResponse {
    private Map<String,String> errors;
}

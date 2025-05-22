package com.ecommerce.exceptions;

import lombok.Builder;

import java.util.Map;

@Builder
public class ErrorResponse {
    private Map<String,String> errors;
}

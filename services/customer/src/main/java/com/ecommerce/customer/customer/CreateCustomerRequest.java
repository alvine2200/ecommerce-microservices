package com.ecommerce.customer.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CreateCustomerRequest(
        String id,
        @NotNull(message = "Customer First Name is required")
        String firstName,
        @NotNull(message = "Customer Last Name is required")
        String lastName,
        @NotNull(message = "Email is required")
        @Email(message = "Email must be valid email")
        String email,
        Address address
) {
}

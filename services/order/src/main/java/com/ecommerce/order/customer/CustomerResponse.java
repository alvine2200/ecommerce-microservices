package com.ecommerce.order.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponse {
    private String id;

    private String firstname;

    private String lastname;

    private String email;
}

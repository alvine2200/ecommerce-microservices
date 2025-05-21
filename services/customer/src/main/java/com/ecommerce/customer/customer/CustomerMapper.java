package com.ecommerce.customer.customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toCustomer(CreateCustomerRequest createCustomerRequest) {
        if (createCustomerRequest == null){
            return null;
        }
        return Customer.builder()
                .id(createCustomerRequest.id())
                .email(createCustomerRequest.email())
                .address(createCustomerRequest.address())
                .lastName(createCustomerRequest.lastName())
                .firstName(createCustomerRequest.firstName())
                .build();
    }
}

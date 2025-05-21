package com.ecommerce.customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<String>  createCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(@RequestBody @Valid CreateCustomerRequest createCustomerRequest){
        customerService.updateCustomer(createCustomerRequest);
        return ResponseEntity.accepted().build();
    }
}


package com.ecommerce.customer.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private  final CustomerMapper customerMapper;

    public String createCustomer(CreateCustomerRequest createCustomerRequest) {
        return customerRepository.save(customerMapper.toCustomer(createCustomerRequest)).getId();
    }

    public void updateCustomer(@Valid CreateCustomerRequest createCustomerRequest) {
        var customer = customerRepository.findById(createCustomerRequest.id())
                .orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));
        mergeCustomer(customer,createCustomerRequest);
        customerRepository.save(customer);
    }

    private void mergeCustomer(Customer customer, @Valid CreateCustomerRequest createCustomerRequest) {

    }


}

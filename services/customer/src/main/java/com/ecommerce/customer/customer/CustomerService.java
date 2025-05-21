package com.ecommerce.customer.customer;

import com.ecommerce.customer.customer.exceptions.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (StringUtils.isNotBlank(createCustomerRequest.email())){
            customer.setEmail(createCustomerRequest.email());
        }

        if (StringUtils.isNotBlank(createCustomerRequest.firstName())){
            customer.setFirstName(createCustomerRequest.firstName());
        }

        if (StringUtils.isNotBlank(createCustomerRequest.lastName())){
            customer.setLastName(createCustomerRequest.lastName());
        }

        if (createCustomerRequest.address() != null){
            customer.setAddress(createCustomerRequest.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toCustomerResponse)
                .collect(Collectors.toList());
    }


    public Boolean checkIfCustomerExists(String customerId) {
        return customerRepository.existsById(customerId);
    }

    public CustomerResponse findCustomerById(String customerId) {
        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(()-> new CustomerNotFoundException("Customer Not Found "));
    }

    public Void deleteCustomer(String customerId) {
        customerRepository.deleteById(customerId);
    }
}

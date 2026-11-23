package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.Repository.CustomerRepository;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.transformer.CustomerTransformer;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        // Request DTO to entity conversion
      Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);

    //saved the entity to db
     Customer savedCustomer = customerRepository.save(customer);

     return CustomerTransformer.customerToCustomerResponse(customer);

    }

    public CustomerResponse getCustomer(int customerId) {
       Optional<Customer> optinalCustomer =  customerRepository.findById(customerId);
       if(optinalCustomer.isEmpty()){
           throw new CustomerNotFoundException("Invalid customer Result");
       }
        Customer savedCustomer = optinalCustomer.get();
       //saved entity -> Respnse DTO
        return CustomerTransformer.customerToCustomerResponse(savedCustomer);
    }

    public List<CustomerResponse> getAllByGender(Gender gender) {
    List<Customer> customers = customerRepository.findByGender(gender);
    //entity to responseDto
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses
                    .add(CustomerTransformer
                    .customerToCustomerResponse(customer));
        }
        return customerResponses;
    }

    public List<CustomerResponse> getAllByGenderAndAge(Gender gender, int age) {
        List<Customer> customers = customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses
                    .add(CustomerTransformer
                            .customerToCustomerResponse(customer));
        }
        return customerResponses;

    }

    public List<CustomerResponse> getAllByGenderAndAgeGreaterThan(String gender, int age) {
        List<Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer : customers){
            customerResponses
                    .add(CustomerTransformer
                            .customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}

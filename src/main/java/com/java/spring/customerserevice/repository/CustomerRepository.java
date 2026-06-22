package com.java.spring.customerserevice.repository;

import com.java.spring.customerserevice.document.Customer;
import com.java.spring.customerserevice.dto.request.LoginRequestDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    Optional<Customer> findByEmailAndPassword(String email,String password);
    Optional<Customer> findByName(String name);
}

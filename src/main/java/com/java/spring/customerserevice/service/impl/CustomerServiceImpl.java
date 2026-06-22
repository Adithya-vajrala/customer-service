package com.java.spring.customerserevice.service.impl;

import com.java.spring.customerserevice.document.Customer;
import com.java.spring.customerserevice.dto.request.LoginRequestDto;
import com.java.spring.customerserevice.dto.request.SignupRequestDto;
import com.java.spring.customerserevice.dto.response.LoginResponseDto;
import com.java.spring.customerserevice.dto.response.SignupResponseDto;
import com.java.spring.customerserevice.enums.Status;
import com.java.spring.customerserevice.exception.CustomerExistsException;
import com.java.spring.customerserevice.exception.CustomerNotFoundException;
import com.java.spring.customerserevice.repository.CustomerRepository;
import com.java.spring.customerserevice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;
    private final ModelMapper mapper;

    @Override
    public SignupResponseDto signup(SignupRequestDto dto) throws CustomerExistsException {
        repository.findByName(dto.getName()).ifPresent(Customer-> {
            throw new CustomerExistsException("Customer is Already there with this "+ dto.getName());
        });
        Customer customer = mapper.map(dto,Customer.class);
        customer.setStatus(Status.INACTIVE);
        customer.setCreatedAt(LocalDateTime.now());
        return mapper.map(repository.save(customer), SignupResponseDto.class) ;
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) throws CustomerNotFoundException {
        return mapper.map(repository.findByEmailAndPassword(dto.getEmail(),dto.getPassword()).orElseThrow(()->
            new CustomerNotFoundException("there is no customer with this " + dto.getEmail() + " and " + dto.getPassword()))
                ,LoginResponseDto.class);
    }
}

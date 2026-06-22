package com.java.spring.customerserevice.service;

import com.java.spring.customerserevice.dto.request.LoginRequestDto;
import com.java.spring.customerserevice.dto.request.SignupRequestDto;
import com.java.spring.customerserevice.dto.response.ApiResponseDto;
import com.java.spring.customerserevice.dto.response.LoginResponseDto;
import com.java.spring.customerserevice.dto.response.SignupResponseDto;
import com.java.spring.customerserevice.exception.CustomerExistsException;
import com.java.spring.customerserevice.exception.CustomerNotFoundException;
import org.springframework.http.ResponseEntity;

public interface CustomerService {
    SignupResponseDto signup(SignupRequestDto dto)throws CustomerExistsException;
    LoginResponseDto login(LoginRequestDto dto) throws CustomerNotFoundException;
}

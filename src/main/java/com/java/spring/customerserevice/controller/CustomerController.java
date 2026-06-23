package com.java.spring.customerserevice.controller;

import com.java.spring.customerserevice.dto.request.LoginRequestDto;
import com.java.spring.customerserevice.dto.request.SignupRequestDto;
import com.java.spring.customerserevice.dto.response.ApiResponseDto;
import com.java.spring.customerserevice.dto.response.LoginResponseDto;
import com.java.spring.customerserevice.dto.response.SignupResponseDto;
import com.java.spring.customerserevice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService service;
    private final ModelMapper modelMapper;
    @PostMapping("/signup")
    public ResponseEntity<ApiResponseDto<SignupResponseDto>> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponseDto.<SignupResponseDto>builder()
                        .success(true)
                        .code(HttpStatus.CREATED.value())
                        .message("Customer SignedUp successfully")
                        .data(service.signup(signupRequestDto))
                        .build()
        );
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponseDto<LoginResponseDto>> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok().body(
                ApiResponseDto.<LoginResponseDto>builder()
                        .success(true)
                        .code(HttpStatus.OK.value())
                        .message("Customer is there")
                        .data(service.login(loginRequestDto))
                        .build()
        );
    }


}

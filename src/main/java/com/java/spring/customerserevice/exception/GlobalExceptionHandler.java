package com.java.spring.customerserevice.exception;

import com.java.spring.customerserevice.dto.response.ApiResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApiResponseDto<String>> handleCustomerNotFoundException(CustomerNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponseDto.<String>builder()
                .success(false)
                .code(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .data(ex.getMessage())
                .build());
    }

    @ExceptionHandler(CustomerExistsException.class)
    public ResponseEntity<ApiResponseDto<String>> handleCustomerExistsException(CustomerExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ApiResponseDto.<String>builder()
                .success(false)
                .code(HttpStatus.CONFLICT.value())
                .message(ex.getMessage())
                .data(ex.getMessage())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<String>> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ApiResponseDto.<String>builder()
                .success(false)
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .data(ex.getMessage())
                .build());
    }

}

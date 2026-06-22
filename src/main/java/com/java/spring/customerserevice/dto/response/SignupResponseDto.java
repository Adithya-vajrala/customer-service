package com.java.spring.customerserevice.dto.response;

import com.java.spring.customerserevice.enums.Gender;
import com.java.spring.customerserevice.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupResponseDto {
    private String id;
    private String name;
    private String email;
    private Gender gender;
    private long phone;
    private Status status;
    private LocalDateTime createdAt;
}

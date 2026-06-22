package com.java.spring.customerserevice.dto.request;

import com.java.spring.customerserevice.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequestDto {
    private String name;
    private String email;
    private Gender gender;
    private long phone;
    private String password;
}

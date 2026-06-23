package com.java.spring.customerserevice.dto.request;

import com.java.spring.customerserevice.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequestDto {
    @NotBlank(message = "Name required")
    @Pattern(
            regexp = "^[A-Za-z ]{2,50}$",
            message = "Invalid username"
    )
    private String name;
    @NotBlank(message = "Email not Empty")
    @Email(message = "Invalid email format ")
    private String email;
    private Gender gender;

    private long phone;
    @NotBlank(message = "password is required")
    @Size(
            min = 8,
            message = "Password is in minimum size"
    )
    private String password;
}

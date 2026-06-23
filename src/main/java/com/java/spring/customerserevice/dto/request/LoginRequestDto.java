package com.java.spring.customerserevice.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto {
    @NotBlank(message = "Email required")
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message = "Password Required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&^#()_+=-])[A-Za-z\\\\d@$!%*?&^#()_+=-]{8,}$",
            message = "Password must contain uppercase, lowercase, number, special character and be at least 8 characters long"

    )
    private String password;
}

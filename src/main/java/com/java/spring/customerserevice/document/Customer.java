package com.java.spring.customerserevice.document;

import com.java.spring.customerserevice.enums.Gender;
import com.java.spring.customerserevice.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private Gender gender;
    private long phone;
    private Status status;
    private String password;
    private LocalDateTime createdAt;
}

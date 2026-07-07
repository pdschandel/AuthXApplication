package com.example.AuthXApplication.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    @Size(max = 80)
    @NotBlank
    private String firstName;
    @Size(max = 80)
    private String lastName;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min =8 ,max = 80)
    private String password;
}

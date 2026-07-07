package com.example.AuthXApplication.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @Valid
    private String email;

    @NotBlank
    private String password;
}

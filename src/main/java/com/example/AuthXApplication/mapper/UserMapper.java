package com.example.AuthXApplication.mapper;

import com.example.AuthXApplication.Model.User;
import com.example.AuthXApplication.dto.request.RegisterRequest;
import com.example.AuthXApplication.dto.response.RegisterResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(RegisterRequest registerRequest,String encodedPassword){
        return User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .password(encodedPassword)
                .email(registerRequest.getEmail())
                .build();
    }

    public RegisterResponse toResponse(User user){
        return RegisterResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}

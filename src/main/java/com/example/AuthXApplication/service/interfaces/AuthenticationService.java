package com.example.AuthXApplication.service.interfaces;

import com.example.AuthXApplication.dto.request.LoginRequest;
import com.example.AuthXApplication.dto.request.RegisterRequest;
import com.example.AuthXApplication.dto.response.LoginResponse;
import com.example.AuthXApplication.dto.response.RegisterResponse;

public interface AuthenticationService {
    public RegisterResponse register(RegisterRequest registerRequest);
    public LoginResponse login(LoginRequest loginRequest);
}

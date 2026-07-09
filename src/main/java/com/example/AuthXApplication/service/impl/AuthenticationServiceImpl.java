package com.example.AuthXApplication.service.impl;

import com.example.AuthXApplication.Model.User;
import com.example.AuthXApplication.dto.request.LoginRequest;
import com.example.AuthXApplication.dto.request.RegisterRequest;
import com.example.AuthXApplication.dto.response.LoginResponse;
import com.example.AuthXApplication.dto.response.RegisterResponse;
import com.example.AuthXApplication.exception.EmailAlreadyExistsException;
import com.example.AuthXApplication.exception.InvalidCredentialsException;
import com.example.AuthXApplication.mapper.UserMapper;
import com.example.AuthXApplication.repository.UserRepository;
import com.example.AuthXApplication.service.interfaces.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final JwtServiceImpl jwtService;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new EmailAlreadyExistsException(registerRequest.getEmail());
        }
        final String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());
        User user =userMapper.toEntity(registerRequest,encodedPassword);
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(
                loginRequest.getPassword(),
                user.getPassword())) {

            throw new InvalidCredentialsException();
        }

        return LoginResponse.builder()
                .accessToken(jwtService.generateAccessToken(user))
                .build();
    }
}

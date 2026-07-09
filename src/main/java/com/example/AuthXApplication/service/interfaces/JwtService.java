package com.example.AuthXApplication.service.interfaces;

import com.example.AuthXApplication.Model.User;

public interface JwtService {
    String generateAccessToken(User user);
    String extractUsername(String token);
    boolean isTokenValid(String token, User user);
}

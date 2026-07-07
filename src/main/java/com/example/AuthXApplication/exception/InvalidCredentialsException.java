package com.example.AuthXApplication.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException (){
        super("Invalid Credentials");
    }
}

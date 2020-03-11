package com.example.jpa.SpringJpa.Exception;

import javax.naming.AuthenticationException;

public class UserAlreadyExistException extends AuthenticationException {
    public UserAlreadyExistException(String errorMessage){
        super(errorMessage);
    }

}

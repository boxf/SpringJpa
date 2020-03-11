package com.example.jpa.SpringJpa.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "This email already exists")
public class ConflictException extends RuntimeException {


}

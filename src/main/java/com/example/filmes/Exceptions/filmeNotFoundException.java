package com.example.filmes.Exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class filmeNotFoundException extends ResponseStatusException {

    public filmeNotFoundException(String response) {
        super(HttpStatus.NOT_FOUND, response);
    }
}

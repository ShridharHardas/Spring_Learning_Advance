package com.shridhar.production.production.advice;

import com.shridhar.production.production.exception.ResourceNotFoundException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.naming.AuthenticationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleException(ResourceNotFoundException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<ApiError> handleException(JwtException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ApiError> handleException(AuthenticationException e) {
        ApiError apiError = new ApiError(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}

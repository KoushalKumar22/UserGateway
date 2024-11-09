package com.UserAcces.UsersGateway.Handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstrainViolation(ConstraintViolationException exception){
        Map<String,String> errors=new HashMap<>();
        exception.getConstraintViolations().forEach(violation -> {
            String propertyPath=violation.getPropertyPath().toString();
            String errorMessage=violation.getMessage();
            errors.put(propertyPath, errorMessage);
        });
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrity(DataIntegrityViolationException exception){
        String errorMessage="Data Base Error Occurred";
        if (exception.getMessage().contains("(phone_no)")) {
            errorMessage = "Phone number already exists.";
        } else if (exception.getMessage().contains("(email_id)")) {
            errorMessage = "EmailId already exists.";
        } else if (exception.getMessage().contains("(user_name)")) {
            errorMessage = "UserName already exists.";
        }
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}

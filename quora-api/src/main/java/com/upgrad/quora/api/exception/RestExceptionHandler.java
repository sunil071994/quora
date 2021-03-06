package com.upgrad.quora.api.exception;


import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


// This class is created to handle the exception from the controller class.
// The error response is created as per the exception and are returned.

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> userNotFoundException(UserNotFoundException exc , WebRequest request){

        return new ResponseEntity<ErrorResponse>(new ErrorResponse()
                .code(exc.getCode())
                .message(exc.getErrorMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> authorizationFailedException(AuthorizationFailedException exc , WebRequest request){

        return new ResponseEntity<ErrorResponse>(new ErrorResponse()
                .code(exc.getCode())
                .message(exc.getErrorMessage()),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(InvalidQuestionException.class)
    public ResponseEntity<ErrorResponse> invalidQuestionException(InvalidQuestionException exc, WebRequest request){

        return new ResponseEntity<ErrorResponse>(new ErrorResponse()
                .code(exc.getCode())
                .message(exc.getErrorMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundException(SignUpRestrictedException exception, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> authenticationException(AuthenticationFailedException exception, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> signOutException(SignOutRestrictedException exception, WebRequest request){
        ErrorResponse errorResponse = new ErrorResponse().code(exception.getCode()).message(exception.getErrorMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
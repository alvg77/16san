package com.ssan.api16san.controller.advice;

import com.ssan.api16san.exceptions.UnauthorizedException;
import com.ssan.api16san.exceptions.UserBanException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UserBanAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(UserBanException.class)
    public ResponseEntity<?> handleUserBan(UserBanException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}

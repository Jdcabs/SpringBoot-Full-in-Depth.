package com.dailycode.springtutorial.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.dailycode.springtutorial.model.ErrorMessage;
@ControllerAdvice
@ResponseStatus
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentNotFound(DepartmentNotFoundException depNotFound, 
                                            WebRequest webRequest) {
            ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, depNotFound.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}

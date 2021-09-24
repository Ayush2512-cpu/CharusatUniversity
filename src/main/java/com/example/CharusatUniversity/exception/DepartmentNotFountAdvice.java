package com.example.CharusatUniversity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DepartmentNotFountAdvice {
    @ResponseBody
    @ExceptionHandler(DepartmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String courseNotFoundHandler(DepartmentNotFoundException ex) {
        return ex.getMessage();
    }

}

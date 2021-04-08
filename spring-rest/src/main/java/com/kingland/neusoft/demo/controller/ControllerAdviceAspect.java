package com.kingland.neusoft.demo.controller;

import com.kingland.neusoft.demo.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceAspect {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionModel> handleException(Exception e) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setMessage(e.getMessage());
        exceptionModel.setDetail("Error when handle request");
        return new ResponseEntity(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionModel> handleCommonException(Exception e) {
        ExceptionModel exceptionModel = new ExceptionModel();
        exceptionModel.setMessage(e.getMessage());
        exceptionModel.setDetail("Error when handle request");
        return new ResponseEntity(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

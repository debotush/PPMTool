package com.damdebotush.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> projectIdException(ProjectIdException ex, WebRequest request) {
        ProjectExceptionResponse projectExceptionResponse = new ProjectExceptionResponse(ex.getMessage());
        return new ResponseEntity( projectExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}

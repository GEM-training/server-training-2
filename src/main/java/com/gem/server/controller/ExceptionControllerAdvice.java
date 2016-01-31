package com.gem.server.controller;

import com.gem.server.model.ResponseObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by hoak57uet on 1/31/16.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseObject exceptionHandle(Exception e) {
        return new ResponseObject(false, e.getMessage(), null);
    }
}

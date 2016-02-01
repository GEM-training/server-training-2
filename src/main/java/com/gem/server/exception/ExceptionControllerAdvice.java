package com.gem.server.exception;

import com.gem.server.model.ResponseObject;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by hoak57uet on 1/31/16.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
        // Nothing to do
    }

    @ExceptionHandler(ValidateException.class)
    public
    @ResponseBody
    ResponseObject exceptionHandle(HttpServletRequest request, Exception e) {
        return new ResponseObject(false, e.getMessage(), null);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public
    @ResponseBody
    ResponseObject handleError(HttpServletRequest req, Exception exception) {
        return new ResponseObject(false, "Undefined exception", null);
    }

    @ExceptionHandler(IOException.class)
    public
    @ResponseBody
    ResponseObject ioHandle(HttpServletRequest request, Exception e) {
        return new ResponseObject(false, "Your data is incorrect !", null);
    }

    @ExceptionHandler(SQLException.class)
    public
    @ResponseBody
    ResponseObject sqlExceptionHandle(HttpServletRequest request, Exception e) {
        return new ResponseObject(false, "Could not do that right now !", null);
    }


}

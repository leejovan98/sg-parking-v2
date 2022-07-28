package com.jovan.sgparkingv2.config;

import com.jovan.sgparkingv2.controllers.responses.ExceptionResponse;
import com.jovan.sgparkingv2.exceptions.PoorAddressMatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PoorAddressMatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse handlePoorAddressMatchException(PoorAddressMatchException e){
        return ExceptionResponse.builder()
                .errorDetail(String.format("address query for %s returned a poor candidate with score %d", e.getRequestAddress(), e.getScore()))
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse handleException(Exception e){
        return ExceptionResponse.builder()
                .errorDetail("unexpected exception caught")
                .build();
    }

}

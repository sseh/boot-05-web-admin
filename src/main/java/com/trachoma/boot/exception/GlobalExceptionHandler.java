package com.trachoma.boot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author trachoma
 * @create 2022-02-21 13:32
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public String handleArithmeticException(Exception e) {

        log.error("异常是: {}", e.getMessage());
        return "login";
    }
}

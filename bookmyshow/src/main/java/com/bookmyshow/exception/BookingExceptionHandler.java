package com.bookmyshow.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class BookingExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ResponseEntity<Object> handleGeneralException(
            Exception ex, WebRequest request) {
        log.error("Error During DB Operation :{}", errorREsponse(ex, request));
        return new ResponseEntity<>(
                errorREsponse(ex, request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ApiResponse errorREsponse(Exception ex, WebRequest webRequest) {

        return new ApiResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(), ex.getCause().getMessage(), webRequest.getContextPath());
    }
}

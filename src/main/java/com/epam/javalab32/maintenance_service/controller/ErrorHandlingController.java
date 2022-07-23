package com.epam.javalab32.maintenance_service.controller;

import com.epam.javalab32.maintenance_service.exception.ServiceException;
import com.epam.javalab32.maintenance_service.model.CustomError;
import com.epam.javalab32.maintenance_service.model.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomError handleServiceException(ServiceException exception, HandlerMethod handlerMethod) {
        log.error("handleServiceException: message {}, method {}", exception.getMessage(), handlerMethod.getMethod().getName(), exception);
        return new CustomError(exception.getMessage(), exception.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.error("handleMethodArgumentNotValidException: message: {}", exception.getMessage(), exception);
        return exception.getBindingResult().getAllErrors().stream()
                .map(objectError -> new CustomError(objectError.getDefaultMessage(),
                        ErrorType.VALIDATION_ERROR_TYPE,
                        LocalDateTime.now()))
                .collect(Collectors.toList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomError handleException(Exception exception) {
        log.error("handleException: message: {}", exception.getMessage(), exception);
        return new CustomError(exception.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }
}

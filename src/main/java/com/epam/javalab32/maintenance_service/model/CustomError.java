package com.epam.javalab32.maintenance_service.model;

import com.epam.javalab32.maintenance_service.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CustomError {
    private String errorMessage;
    private ErrorType errorType;
    private LocalDateTime localDateTime;
}

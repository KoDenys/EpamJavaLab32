package com.epam.javalab32.maintenance_service.exception;

import com.epam.javalab32.maintenance_service.model.enums.ErrorType;

public class CarNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Car is not found with registration number ";
    private static final String LIST_FOR_USER_MESSAGE = "Cars are not found for this user";

    public CarNotFoundException() {
        super(LIST_FOR_USER_MESSAGE);
    }

    public CarNotFoundException(String regNumber) {
        super(DEFAULT_MESSAGE + regNumber);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.NOT_FOUND_ERROR_TYPE;
    }
}

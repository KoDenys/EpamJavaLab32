package com.epam.javalab32.maintenance_service.exception;

import com.epam.javalab32.maintenance_service.model.enums.ErrorType;

public class UserNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "User is not found with email ";

    public UserNotFoundException(String email) {
        super(DEFAULT_MESSAGE + email);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.NOT_FOUND_ERROR_TYPE;
    }
}

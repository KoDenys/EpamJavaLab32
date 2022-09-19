package com.epam.javalab32.maintenance_service.exception;

import com.epam.javalab32.maintenance_service.model.enums.ErrorType;

public class UserNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "User is not found with email ";
    private static final String ID_MESSAGE = "User is not found with id = ";
    private static final String ALL_MESSAGE = "Users are not found";

    public UserNotFoundException(Long id) {
        super(ID_MESSAGE + id);
    }

    public UserNotFoundException(String email) {
        super(DEFAULT_MESSAGE + email);
    }
    public UserNotFoundException() {
        super(ALL_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.NOT_FOUND_ERROR_TYPE;
    }
}

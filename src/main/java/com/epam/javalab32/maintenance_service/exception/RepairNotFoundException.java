package com.epam.javalab32.maintenance_service.exception;

import com.epam.javalab32.maintenance_service.model.enums.ErrorType;

public class RepairNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Repair is not found with id ";
    private static final String LIST_FOR_CAR_MESSAGE = "Repairs are not found for this car";

    public RepairNotFoundException() {
        super(LIST_FOR_CAR_MESSAGE);
    }

    public RepairNotFoundException(Long id) {
        super(DEFAULT_MESSAGE + id);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.NOT_FOUND_ERROR_TYPE;
    }
}

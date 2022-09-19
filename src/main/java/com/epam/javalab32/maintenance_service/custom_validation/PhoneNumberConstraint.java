package com.epam.javalab32.maintenance_service.custom_validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message() default "Phone number is not valid, should contains from 10 to 12 numbers";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

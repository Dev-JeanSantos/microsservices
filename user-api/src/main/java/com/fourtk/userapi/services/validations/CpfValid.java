package com.fourtk.userapi.services.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CpfValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfValid {
    String message() default "Validation error";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package ro.irian.labs.pizza.service.api;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueNameValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueName {
    String message() default "Name must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


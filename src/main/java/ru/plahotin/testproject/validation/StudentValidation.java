package ru.plahotin.testproject.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentValidator.class)
@Documented
public @interface StudentValidation {
    String MESSAGE = "ERROR";

    String message() default MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target(TYPE)
    @Retention(RUNTIME)
    @Documented
    @interface List {
        StudentValidation[] value();
    }

    String name();

    String age();

}

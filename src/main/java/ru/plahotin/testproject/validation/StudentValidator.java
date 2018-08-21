package ru.plahotin.testproject.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class StudentValidator implements ConstraintValidator<StudentValidation, Object> {

    private String name;

    private String age;


    @Override
    public void initialize(StudentValidation constraintAnnotation) {
        this.name = constraintAnnotation.name();
        this.age = constraintAnnotation.age();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String validatingName = (String) getProperty(value, name);
        int validatingAge = (Integer) getProperty(value, age);

        boolean result = validatingAge > 18;

        if (!result) {
            context.disableDefaultConstraintViolation();
            addViolationToField(context, "еще мал", age);
        }

        return result;
    }

    private void addViolationToField(ConstraintValidatorContext context, String msg, String field) {
        context.buildConstraintViolationWithTemplate(msg)
                .addPropertyNode(field)
                .addConstraintViolation();
    }

    private Object getProperty(Object value, String fieldName) {
        Class<?> clazz = value.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            return method.invoke(value);
        } catch (Exception e) {
           // log.error("DeadlineValidator.getProperty", e);
        }
        return null;
    }
}

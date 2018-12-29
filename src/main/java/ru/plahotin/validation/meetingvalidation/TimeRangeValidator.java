package ru.plahotin.validation.meetingvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalTime;

public class TimeRangeValidator implements ConstraintValidator<TimeRange, Object> {

    String startTime;
    String endTime;

    @Override
    public void initialize(TimeRange constraintAnnotation) {
        this.startTime = constraintAnnotation.startTime();
        this.endTime = constraintAnnotation.endTime();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        LocalTime validatingStartTime = (LocalTime) getProperty(value, startTime);
        LocalTime validatingEndTime = (LocalTime) getProperty(value, endTime);


        return false;
    }

    private Object getProperty(Object property, String fieldName) {
        Class clazz = property.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
        try {
            Method method = clazz.getMethod(methodName);
            method.invoke(property);
        } catch (Exception e) {

        }
        return null;
    }
}

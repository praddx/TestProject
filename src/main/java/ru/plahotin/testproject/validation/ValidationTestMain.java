package ru.plahotin.testproject.validation;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

import static ru.plahotin.testproject.validation.ValidatorWrapper.checkOnConstraintViolation;

public class ValidationTestMain {

    public static void main(String[] args) {

        Locale ru = new Locale("ru", "RU");
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(ru);
        Validator validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
        Locale.setDefault(defLocale);

       // Validator validator = Validation.byDefaultProvider().configure().messageInterpolator(new ParameterMessageInterpolator()).buildValidatorFactory().getValidator();



/*        Set<ConstraintViolation<Student>> viol = validator.validate(student);

        viol.stream().map(cv -> cv.getMessage()).forEach(System.out::println);*/



        Student student = new Student("John", 11);
        Student student1 = new Student("afadgfa", 5);

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

       //Set<ConstraintViolation<List<Student>>> violations = validator.validate(students);

        Set<ConstraintViolation<Student>> violations = students.stream().flatMap(s -> validator.validate(s).stream())
                .collect(Collectors.toSet());

        violations.stream().map(cv -> cv.getMessage() + " : " + cv.getRootBean().getName()).forEach(System.out::println);



        /*try {
            checkOnConstraintViolation(student);
        } catch (ValidationException e) {
            e.getValidationResult().getError().stream().
                    map(fi -> fi.getField() + ":" + fi.getText().stream().collect(Collectors.joining(", ")))
                    .forEach(System.out::println);
        }*/
        System.out.println("bla bla");
    }
}


package ru.plahotin.testproject.validation;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

class ValidatorWrapper {
    private static Validator validator;

    static {
        Locale ru = new Locale("ru", "RU");
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(ru);
        validator = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory()
                .getValidator();
        Locale.setDefault(defLocale);
    }

    static <T> void checkOnConstraintViolation(T params) throws ValidationException {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(params);
        if (constraintViolations.size() != 0) {
            ValidationResult validationResult = getViolationResult(constraintViolations);
            throw new ValidationException(validationResult);
        }
    }

    /**
     * @param constraintViolations список всех огранечений
     * @param <T>                  класс с ограничениями
     * @return возвращается null, если нарушений нет, иначе ValidationResult
     */
    private static <T> ValidationResult getViolationResult(Set<ConstraintViolation<T>> constraintViolations) {
        Map<String, List<String>> result = new HashMap<>();
        for (ConstraintViolation violation : constraintViolations) {
            String key = violation.getPropertyPath().toString();
            if (result.containsKey(key)) {
                List<String> messages = result.get(key);
                messages.add(violation.getMessage());
                result.put(key, messages);
            } else {
                List<String> message = new ArrayList<>();
                message.add(violation.getMessage());
                result.put(key, message);
            }
        }
        if (result.size() != 0) {
            List<ValidationResult.FieldsInfo> infoList = new ArrayList<>();
            for (Map.Entry<String, List<String>> it : result.entrySet()) {
                ValidationResult.FieldsInfo fieldsInfo = new ValidationResult.FieldsInfo(it.getKey(), it.getValue());
                infoList.add(fieldsInfo);
            }
            return new ValidationResult(infoList);
        }
        return null;
    }
}

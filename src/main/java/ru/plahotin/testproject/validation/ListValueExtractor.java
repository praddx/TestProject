package ru.plahotin.testproject.validation;

import javax.validation.valueextraction.ExtractedValue;
import javax.validation.valueextraction.ValueExtractor;
import java.util.List;

public class ListValueExtractor implements ValueExtractor<@ExtractedValue(type = Student.class) List<Student>> {
    @Override
    public void extractValues(@ExtractedValue(type = Student.class) List<Student> originalValue, ValueReceiver receiver) {

    }
}

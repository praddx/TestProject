package ru.plahotin.testproject.validation;

import org.hibernate.validator.internal.metadata.aggregated.ValidatableParametersMetaData;


import javax.validation.Valid;
import java.util.List;

public class ValidatableListWrapper<T> {

    @Valid
    private List<T> list;

    public ValidatableListWrapper(List<T> list) {
        this.list = list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

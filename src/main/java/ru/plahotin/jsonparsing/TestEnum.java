package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonSerialize(using = TestEnumSerializer.class)
public enum TestEnum {

    VALUE_ONE(1,"BLA BLA BAL"),

    VALUE_TWO(2, "3 BLA");

    private int code;

    private String name;

    TestEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }


    public void setCode(int code) {
        this.code = code;
    }

//    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

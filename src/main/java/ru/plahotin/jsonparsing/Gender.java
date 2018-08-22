package ru.plahotin.jsonparsing;

public enum Gender {
    M(1, "Male"),
    F(2, "Female");

    int code;
    String description;

    Gender(int code, String description) {
        this.code = code;
        this.description= description;
    }

    public String getDescription() {
        return description;
    }

}

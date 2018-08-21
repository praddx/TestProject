package ru.plahotin.testproject.validation;

import javax.validation.constraints.Size;

@StudentValidation(name = "name", age="age")
public class Student {

    @Size(min = 1, max = 3)
    String name;

    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

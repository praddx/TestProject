package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.annotation.JsonGetter;

public class Student {

    String name;

    int age;

    Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    //@JsonGetter("name")
    public String getTheName() {
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return name + " : " + gender + " : " + age;
    }
}

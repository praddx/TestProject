package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize (using = StudentSerializer.class)
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class Student extends Person {

    List<String> classes = new ArrayList<>();

    List<Mentor> mentors = new ArrayList<>();

    public List<Mentor> getMentors() {
        return mentors;
    }



    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }


    //@JsonGetter("name")
    public String theName() {
        return name.toUpperCase();
    }

    @Override
    public String toString() {
        return name + " : " + gender + " : " + age;
    }
}

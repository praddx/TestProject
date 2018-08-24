package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomDeserializerTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        Student student = new Student();
        student.setGender(Gender.M);
        student.setName("Mark");
        student.setAge(22);

        Mentor mathMentor = new Mentor();
        mathMentor.setSpecialty("Math");
        mathMentor.setAge(42);
        mathMentor.setGender(Gender.F);
        mathMentor.setName("Liza");

        Mentor historyMentor = new Mentor();
        historyMentor.setSpecialty("History");
        historyMentor.setAge(52);
        historyMentor.setGender(Gender.M);
        historyMentor.setName("Bob");


        List<Person> mentors = new ArrayList<>();
        mentors.add(mathMentor);
        mentors.add(historyMentor);
        mentors.add(student);

//        List<String> studentClasses = new ArrayList<>();
//        studentClasses.add("History");
//        studentClasses.add("Philosophy");
//        student.setClasses(studentClasses);

        student.getClasses().add("Calculus");
        student.getClasses().add("History");

//        student.getMentors().add(mathMentor);
//        student.getMentors().add(historyMentor);


        String stringEnum = "0";

//        System.out.println(mapper.writeValueAsString(TestEnum.VALUE_ONE));
//        System.out.println(mapper.writeValueAsString(student));
//
//        System.out.println(mapper.readValue(stringEnum, TestEnum.class).getName());

        TypeReference<List<Person>> type = new TypeReference<List<Person>>() {};
        Person student1 = student;
        System.out.println(mapper.writeValueAsString(student1));
        System.out.println(mapper.writerFor(type).writeValueAsString(mentors));
    }
}

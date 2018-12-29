package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ParserMainTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.findAndRegisterModules();
        mapper.registerModule(new ParameterNamesModule());
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new Jdk8Module());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String jasonString = "bla bla";
        String jasonStudent = "[{\"name\":\"Bob\", \"age\":21, \"gender\":\"M\"},{\"name\":\"Paula\", \"age\":42, \"gender\":\"F\"}]";
        String jasonEnum = "\"M\"";

        String studentSring = "{\"name\":\"Bob\", \"age\":21, \"gender\":\"M\"}";

        String jsonDate = "\"Invalid date\"";

        String jsonDateClass = "{\"date\":\"bla\"}";



        // dateTestObj = mapper.readValue(jsonDateClass, DateClass.class);

        //System.out.println(dateTestObj.getDate());

        Student st = mapper.readValue(studentSring, Student.class);
        System.out.println(st.getName());

        System.out.println(mapper.writeValueAsString(st));



        //TypeReference<List<Student>> type = new TypeReference<List<Student>>() {};

        //String converted = mapper.readValue(jasonString, String.class);
       // Student[] students = mapper.readValue(jasonStudent, Student[].class);

       // List<Student> studentsList = mapper.readValue(jasonStudent, type);

        Gender gender = mapper.readValue(jasonEnum, Gender.class);
        System.out.printf(gender.description);

        //System.out.println(converted);
       // Arrays.stream(students).forEach(System.out::println);
//        studentsList.stream().forEach(System.out::println);

        //LocalDate date = mapper.readValue(jsonDate, LocalDate.class);

        //System.out.println(date);


       // System.out.println(gender);
        //System.out.println(gender.getDescription());

//        Student student = new Student();
//        student.setAge(15);
//        student.setName("Pavel");
//        student.setGender(Gender.M);
//        String toJason = mapper.writeValueAsString(student);
//        System.out.println(toJason);
    }
}

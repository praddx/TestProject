package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ParserMainTest {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.registerModule(new ParameterNamesModule());
        String jasonString = "bla bla";
        String jasonStudent= "[{\"name\":\"Bob\", \"age\":21}, {\"name\":\"Paul\", \"age\":42}]";

        TypeReference<List<Student>> type = new TypeReference<List<Student>>() {};

        //String converted = mapper.readValue(jasonString, String.class);
        Student[] students = mapper.readValue(jasonStudent, Student[].class);

        List<Student> studentsList = mapper.readValue(jasonStudent, type);

        //System.out.println(converted);
       // Arrays.stream(students).forEach(System.out::println);
        studentsList.stream().forEach(System.out::println);
    }
}

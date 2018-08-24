package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class StudentSerializer extends StdSerializer<Student> {

    StudentSerializer() {
        this(null);
    }

    StudentSerializer(Class<? extends Student> vc) {
        super((Class<Student>) vc);
    }

    @Override
    public void serialize(Student value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName("first name");
        gen.writeString(value.getName());
        gen.writeFieldName("age");
        gen.writeString(String.valueOf(value.getAge()));
    }
}

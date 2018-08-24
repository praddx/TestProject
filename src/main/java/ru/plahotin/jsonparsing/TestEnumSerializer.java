package ru.plahotin.jsonparsing;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class TestEnumSerializer extends StdSerializer<TestEnum> {


    protected TestEnumSerializer() {
        super(TestEnum.class);
    }

    protected TestEnumSerializer(Class<TestEnum> t) {
        super(t);
    }

    @Override
    public void serialize(TestEnum value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeFieldName("id");
        gen.writeString(value.name());
        gen.writeFieldName("description");
        gen.writeString(value.getName());
    }
}

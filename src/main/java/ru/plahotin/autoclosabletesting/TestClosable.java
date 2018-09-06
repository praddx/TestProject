package ru.plahotin.autoclosabletesting;

import java.io.IOException;

public class TestClosable implements AutoCloseable {

    String name = "TestClosable";

    @Override
    public void close() throws IOException {
        System.out.println("CLOSING " + name);
        close();
    }
}

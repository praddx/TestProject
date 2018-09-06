package ru.plahotin.autoclosabletesting;

import java.io.IOException;

public class ClosableMainTest {

    public static void main(String[] args) {

        try {
            execute();
        } catch (IOException e) {
            System.out.println("logging error");
        }

    }

    public static void execute() throws IOException {
        try (TestClosable test = new TestClosable()) {
            System.out.println("BLA BLA");
            throw new IOException();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}

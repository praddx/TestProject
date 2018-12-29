package ru.plahotin.exceptions;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class MainTest {

    public static void main(String[] args) {
        TestClass test = new TestClass();

        System.out.println("BEFORE");
        try {
            Random ran = new Random();
            int i = ran.nextInt(5 + 1);
            System.out.println(i);
            if (i < 3) {
                throw new Exception();
            }
            System.out.println("AFTER");
        } catch (Exception e) {
            System.out.println("exception catched");
        }
    }
}

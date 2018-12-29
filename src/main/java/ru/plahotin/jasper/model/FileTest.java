package ru.plahotin.jasper.model;

import java.io.File;

public class FileTest {

    public static void main(String[] args) throws Exception{
        File file = new File("src/main/resources/testFile.txt");

        file.createNewFile();
    }
}

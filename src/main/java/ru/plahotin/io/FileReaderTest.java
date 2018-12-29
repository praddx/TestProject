package ru.plahotin.io;

import java.io.FileReader;

public class FileReaderTest {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("D:\\RedApps\\VatApp\\XTRED-470\\ItineraryFromLog.xml");
        System.out.println(fileReader.read());
    }
}

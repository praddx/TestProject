package ru.plahotin.jsonparsing;

import java.io.IOException;

public class Random {
    public static void main(String[] args) {
        try {
            System.out.println("Opening notepad");
            Runtime runTime = Runtime.getRuntime();
            Process process = runTime.exec("eclipse");
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Closing notepad");
            process.destroy();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

}

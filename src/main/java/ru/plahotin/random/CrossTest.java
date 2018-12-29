package ru.plahotin.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CrossTest {

    public static void main(String[] args) {
        String s = "I\u00a5";
        String str = s + "blablabla";
        if (str.startsWith("I\u00a5")) {
            System.out.println(str);
            System.out.println(str.substring(2));
        }

        List<A> a = new ArrayList<>();
    }

    public static class A{
        B b;

        public B getB() {
            return b;
        }

        public void setB(B b) {
            this.b = b;
        }
    }

    public static class B{
        String c;

        public String getC() {
            return c;
        }

        public void setC(String c) {
            this.c = c;
        }
    }
}

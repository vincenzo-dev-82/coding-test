package com.vincenzo;

public class StringTest {

    public static void splitTest() {
        String test = "2 016A 19A 12";
        String[] splits = test.split("A");

        for (String s : splits) {
            System.out.println(s.replaceAll(" ", ""));
        }
    }

    public static void main(String[] args) {
        splitTest();
    }
}

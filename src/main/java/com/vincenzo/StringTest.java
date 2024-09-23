package com.vincenzo;

public class StringTest {

    public static void splitTest() {
        String test = "2 016p 19p 12";
        String[] splits = test.split("p");

        for (String s : splits) {
            System.out.println(s.replaceAll(" ", ""));
        }
    }

    public static void main(String[] args) {
        splitTest();
    }
}

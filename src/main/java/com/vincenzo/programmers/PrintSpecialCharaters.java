package com.vincenzo.programmers;

import javax.swing.*;

public class PrintSpecialCharaters {

    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        String prefix = my_string.substring(0, s);
        int prefixLength = prefix.length();

        String subStr1 = my_string.substring(s, overwrite_string.length());
        int subStrLength = subStr1.length();

        if(my_string.length() > overwrite_string.length()) {
            answer = prefix + subStr1 + my_string.substring(prefixLength + subStrLength, my_string.length());
        } else {
            answer = prefix + subStr1;
        }

        return answer;
    }

    public String solution(String str1, String str2) {
        String answer = "";

        // 두 문자열 중 더 짧은 길이만큼 반복
        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
            char char1 = str1.charAt(i);
            char char2 = str2.charAt(j);

            answer += String.valueOf(char1) + String.valueOf(char2);
        }

        return answer;
    }


    public static void main(String[] args) {

        String test = "!@#$%^&*(\\'\"<>?:;";
        System.out.println("!@#$%^&*(\\'\"<>?:;");
    }
}

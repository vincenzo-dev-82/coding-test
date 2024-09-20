package com.vincenzo.programmers;

import java.util.Scanner;

public class AlphabetSolution {

    public String solution(String word) {

        String result = "";
        int temp = 0;
        for(int i = 0; i < word.length(); i++) {

            temp = word.charAt(i);
            if(temp >= 'A' && temp <= 'Z') {
                temp = temp + 32;
                result = result + (char)(temp);
            } else if(temp >= 'a' && temp <= 'z') {
                temp = temp - 32;
                result = result + (char)(temp);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        AlphabetSolution solution = new AlphabetSolution();
        String reuslt = solution.solution(str);

        System.out.println(reuslt);
    }
}

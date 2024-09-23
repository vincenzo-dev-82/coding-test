package com.vincenzo.basic;

import java.util.Scanner;

public class HasNextline {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int lineCount = 0;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(line.isBlank()) {
                break;
            }
            lineCount++;
        }
        System.out.println(lineCount);
    }
}

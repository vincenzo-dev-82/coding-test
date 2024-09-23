package com.vincenzo.basic;

import java.util.Scanner;

/**
 * 설명: 불리언 이중배열에 테두리만 true 세팅하기
 * T T T T T T
 * T f f f f T
 * T f f f f T
 * T T T T T T
 */
public class PrintLayout {

    public static void printLayout(int widthSize, int heightSize) {

        int rows = widthSize; // 행 개수
        int cols = heightSize; // 열 개수
//        boolean[][] array = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
//                    array[i][j] = true;
                    System.out.print("T");
                } else {
//                    array[i][j] = false;
                    System.out.print("f");
                }
            }
            System.out.println();
        }
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        printLayout(width, height);
    }
}

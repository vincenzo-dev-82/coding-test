package com.vincenzo.basic;

import java.util.List;

public class ListToArrayTest2 {

    public static int[] convertListToOneDimentionalArray(List<Integer> lists) {
        int[] result = lists.stream().mapToInt(i -> i).toArray();
        return result;
    }

    public static int[][] convertListToTwoDimentionalArray(List<List<Integer>> lists) {
        // Stream을 사용하여 2차원 배열로 변환
        int[][] array = lists.stream()
                .map(list -> list.stream().mapToInt(Integer::intValue).toArray()) // list의 Integer를 꺼내서 배열로 바꾼다
                .toArray(int[][]::new);

        return array;
    }

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3);
        int[] oneDimentionalArray = convertListToOneDimentionalArray(list);
        for(int i : oneDimentionalArray) {
            System.out.println(i);
        }
        System.out.println();
        System.out.println("==================");

        // 예시로 사용할 List<List<Integer>> 변수
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        // 2차원 배열로 변환
        int[][] array = convertListToTwoDimentionalArray(lists);

        // 배열 출력
        for (int[] row : array) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

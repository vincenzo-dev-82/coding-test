package com.vincenzo.basic;

import java.util.List;

public class ListToArrayTest {

    public static int[][] convertListToArray(List<List<Integer>> lists) {
        // 리스트의 크기에 맞는 2차원 배열 생성
        int[][] array = new int[lists.size()][];
        for(int i = 0; i < lists.size(); i++) {
            List<Integer> innerList = lists.get(i);
            array[i] = new int[innerList.size()];
            for(int j = 0; j < innerList.size(); j++) {
                array[i][j] = innerList.get(j);
            }
        }
        return array;
    }

    public static void main(String[] args) {

        // 예시로 사용할 List<List<Integer>> 변수
        List<List<Integer>> lists = List.of(
                List.of(1, 2, 3),
                List.of(4, 5, 6),
                List.of(7, 8, 9)
        );

        // 2차원 배열로 변환
        int[][] array = convertListToArray(lists);

        // 배열 출력
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

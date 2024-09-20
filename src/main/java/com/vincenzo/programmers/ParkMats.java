package com.vincenzo.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class ParkMats {

    public int solution(int[] mats, String[][] park) {
        int answer = 0;

        Integer[] intArr = new Integer[] {1,3,2,5,4};
//        // 오름차순 정렬
//        Arrays.sort(mats, (a, b) -> a - b);
//
//        // 내림차순 정렬
//        Arrays.sort(mats, (a, b) -> b - a);

//        Arrays.sort(mats, new Comparator<Integer[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return 0;
//            }
//        });

        for(int i = 0; i < park.length; i++) {
            myPrint(park[i]);
        }

        return answer;
    }

    void myPrint(String[] innerPark) {

        for(int i = 0; i < innerPark.length; i++) {
            System.out.print(innerPark[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /**
         * 입출력 예
         * mats	park	result
         * [5,3,2]	[["A", "A", "-1", "B", "B", "B", "B", "-1"], ["A", "A", "-1", "B", "B", "B", "B", "-1"], ["-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"], ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"], ["D", "D", "-1", "-1", "-1", "-1", "-1", "F"], ["D", "D", "-1", "-1", "-1", "-1", "E", "-1"]]	3
         * 입출력 예 설명
         * 입출력 예 #1
         *
         * 지문과 동일합니다.
         */

        int[] mats = {5, 3, 2};
        String[][] park = {
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
        };


        ParkMats solution = new ParkMats();
        solution.solution(mats, park);
    }
}

package com.vincenzo.interview;

import java.util.Arrays;

/**
 * 문자열 두 개가 서로 순열(permutation) 관계에 있는지 확인하는 메서드를 작성하는 방법을 설명드리겠습니다.
 * 순열 관계란 두 문자열이 동일한 문자들을 동일한 개수만큼 포함하고 있지만, 문자들의 순서가 다를 수 있는 경우를 의미합니다.
 */
public class PermutationTest2 {

    public boolean permutation(String origin, String compare) {
        if(origin.length() != compare.length()) {
            return false;
        }

        int[] letters = new int[128]; // 가정: 문자집합으로 ASCII를 사용한다고 가정
        char[] originArray = origin.toCharArray();
        for(char c : originArray) {
            letters[c]++; // 각 문자의 출현 횟수를 센다
        }

        for(int i = 0; i < compare.length(); i++) {
            char compareChar = compare.charAt(i);
            letters[compareChar] --;
            if(letters[compareChar] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String origin = "abcde";
        String compare = "edcba";

        PermutationTest2 test = new PermutationTest2();
        boolean result = test.permutation(origin, compare);

        System.out.println(result);
    }
}

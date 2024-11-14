package com.vincenzo.interview.permutation;

import java.util.Arrays;

/**
 * 문자열 두 개가 서로 순열(permutation) 관계에 있는지 확인하는 메서드를 작성하는 방법을 설명드리겠습니다.
 * 순열 관계란 두 문자열이 동일한 문자들을 동일한 개수만큼 포함하고 있지만, 문자들의 순서가 다를 수 있는 경우를 의미합니다.
 */
public class PermutationTest1 {

    public String mySort(String origin) {
        char[] chars = origin.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public boolean permutation(String origin, String compare) {
        if(origin.length() != compare.length()) {
            return false;
        }
        return mySort(origin).equals(mySort(compare));
    }

    public static void main(String[] args) {

        String origin = "abcde";
        String compare = "edcba";

        PermutationTest1 test = new PermutationTest1();
        boolean result = test.permutation(origin, compare);

        System.out.println(result);
    }
}

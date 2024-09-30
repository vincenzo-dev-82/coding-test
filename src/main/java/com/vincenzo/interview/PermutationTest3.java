package com.vincenzo.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * 문자열 두 개가 서로 순열(permutation) 관계에 있는지 확인하는 메서드를 작성하는 방법을 설명드리겠습니다.
 * 순열 관계란 두 문자열이 동일한 문자들을 동일한 개수만큼 포함하고 있지만, 문자들의 순서가 다를 수 있는 경우를 의미합니다.
 */
public class PermutationTest3 {

    public boolean permutation(String origin, String compare) {
        // 길이가 다르면 순열 관계가 아님
        if (origin.length() != compare.length()) {
            return false;
        }

        // 문자 빈도수를 저장할 맵 생성
        Map<Character, Integer> charCount = new HashMap<>();

        // 첫 번째 문자열의 문자 빈도수 세기
        for (char c : origin.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // 두 번째 문자열의 문자 빈도수 감소시키기
        for (char c : compare.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false;
            }
        }

        // 모든 문자의 빈도수가 0인지 확인
        for (int count : charCount.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String origin = "abcde";
        String compare = "edcba";

        PermutationTest3 test = new PermutationTest3();
        boolean result = test.permutation(origin, compare);

        System.out.println(result);
    }
}

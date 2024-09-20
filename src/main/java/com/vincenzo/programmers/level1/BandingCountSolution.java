package com.vincenzo.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BandingCountSolution {

    public String[] solution(String order, String[] words) {
        // 정렬할 문자열 배열
        List<String> answer = Arrays.asList(words);

        // 순서에 따른 인덱스 맵을 생성
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        // Comparator 정의 (customOrder를 기준으로 정렬)
        answer.sort((a, b) -> {
            Integer indexA = orderMap.getOrDefault(a.charAt(0), Integer.MAX_VALUE);
            Integer indexB = orderMap.getOrDefault(b.charAt(0), Integer.MAX_VALUE);
            return indexA.compareTo(indexB);
        });

        return answer.toArray(new String[answer.size()]);
    }

    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health; // 최대 체력
        int currentHealth = health; // 현재 체력

        int bandageTime = bandage[0]; // 시전시간
        int healthUp = bandage[1]; // 초당 회복량
        int additionalHealth = bandage[2]; // 추가 회복량

        int bandingCount = 0; // 붕대 감기 연속 성공 시간

        // 공격 리스트의 인덱스를 추적하기 위한 변수
        int attackIndex = 0;

        int maxAttackTime = attacks[attacks.length - 1][0];
        for (int time = 1; time <= maxAttackTime; time++) {
            // 공격이 있는 시간인지 확인
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                int damage = attacks[attackIndex][1];
                currentHealth -= damage;
                if (currentHealth <= 0) {
                    return -1; // 체력이 0 이하이면 죽음
                }
                bandingCount = 0; // 공격을 당하면 붕대 감기 초기화
                attackIndex++; // 다음 공격으로 넘어감
            } else {
                // 공격을 받지 않으면 회복 시작
                bandingCount++;
                currentHealth += healthUp; // 초당 회복량

                if (bandingCount == bandageTime) {
                    currentHealth += additionalHealth; // 추가 회복량
                    bandingCount = 0; // 추가 회복 후 다시 초기화
                }

                // 최대 체력을 넘을 수 없음
                if (currentHealth > maxHealth) {
                    currentHealth = maxHealth;
                }
            }

            // 더 이상의 공격이 없다면 반복 종료
            if (attackIndex >= attacks.length && currentHealth == maxHealth) {
                break;
            }
        }

        return currentHealth;
    }

    public static void main(String[] args) {

        /**
         * bandage	health	attacks	result
         * [5, 1, 5]	30	[[2, 10], [9, 15], [10, 5], [11, 5]]	5
         * [3, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1
         * [4, 2, 7]	20	[[1, 15], [5, 16], [8, 6]]	-1
         * [1, 1, 1]	5	[[1, 2], [3, 2]]	3
         */
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};

        BandingCountSolution solution = new BandingCountSolution();
        int result = solution.solution(bandage, health, attacks);

        System.out.println(result);
    }
}

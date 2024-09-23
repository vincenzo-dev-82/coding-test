package com.vincenzo.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 중앙값 구하기
 * - 평균: 수의 "평균". 모든 수를 더하고 수의 개수로 나눠서 구합니다.
 * - 중앙값: 중앙. 모든 데이터를 크기 순으로 정렬해서 가운데에 있는 데이터를 선택합니다. (가운데에 있는 데이터가 둘이라면 두 수의 평균)
 * - 최빈값: 가장 자주 나온 숫자. 데이터에서 가장 많이 등장한 숫자입니다.
 */
public class MyCenterValueTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 숫자 입력 받기
        System.out.println("숫자들을 입력하세요 (띄어쓰기로 구분):");
        String input = scanner.nextLine();

        // 입력된 숫자들을 배열로 변환
//        String[] inputNumbers = input.split(" ");
//        List<Integer> numbers = new ArrayList<>();
//        for (String numStr : inputNumbers) {
//            numbers.add(Integer.parseInt(numStr));
//        }
        // 입력된 숫자들을 정수 리스트로 변환
        List<Integer> numbers = Arrays.stream(input.split(" ")) // 문자열을 공백으로 분리하여 스트림 생성
                .map(Integer::parseInt) // 각 문자열을 정수로 변환
                .collect(Collectors.toList()); // 결과를 리스트로 수집

        // 중앙값 계산
        Collections.sort(numbers); // 먼저 정렬
        Integer median;

        int size = numbers.size();
        if (size % 2 == 1) {
            // 리스트의 크기가 홀수일 때 중간값
            median = numbers.get(size / 2);
            System.out.println("A: " + median);
        } else {
            // 리스트의 크기가 짝수일 때 두 중앙값은 가운데 두 수의 평균
            median = (numbers.get(size / 2 - 1) + numbers.get(size / 2)) / 2;
            System.out.println("B: " + median + ", size:" + size);
        }

        // 결과 출력
        System.out.println("중간값: " + median);
        System.out.println("정렬된 숫자들: " + numbers);
    }
}

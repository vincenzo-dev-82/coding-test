package com.vincenzo.basic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyLocalDateTest {


    public static List<String> printLocalDateUsingFilter(List<String> dates) {
        DateTimeFormatter yyyyMMdd_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter yyyyMMdd_2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        List<DateTimeFormatter> formatters = Arrays.asList(yyyyMMdd_1, yyyyMMdd_2);

        return dates.stream()
                .flatMap( date -> formatters.stream()
                        .map( formatter -> {
                            try {
                                LocalDate localDate = LocalDate.parse(date, formatter);
                                System.out.println(localDate);
                                return localDate.toString();
                            } catch (DateTimeParseException e) {
                                System.out.println(date + " 날짜형식이 아닙니다");
                                return null; // 변환 실패 시 null 반환
                            }
                        } )
                        .filter(result -> result != null) // null 필터링
                ).collect(Collectors.toList());

//        return dates.stream()
//                .flatMap(date -> formatters.stream()
//                        .map(formatter -> {
//                            try {
//                                LocalDate localDate = LocalDate.parse(date, formatter);
//                                System.out.println(localDate);
//                                return localDate.toString();
//                            } catch (DateTimeParseException e) {
//                                System.out.println(date + " 날짜형식이 아닙니다");
//                                return null; // 변환 실패 시 null 반환
//                            }
//                        })
//                        .filter(result -> result != null) // null 필터링
//                        .findFirst() // 첫 번째 성공한 변환만 선택
//                )
//                .collect(Collectors.toList()); // 결과 리스트로 수집
    }

    public static List<String> printLocalDate(List<String> dates) {

        DateTimeFormatter yyyyMMdd_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter yyyyMMdd_2 = DateTimeFormatter.ofPattern("YYYY/MM/DD");
        List<DateTimeFormatter> formatters = Arrays.asList(yyyyMMdd_1, yyyyMMdd_2);

        List<String> result = new ArrayList<>();
        for(String date : dates) {
            for(DateTimeFormatter formatter : formatters) {
                try {
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    System.out.println(localDate);
                    result.add(localDate.toString());
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println(date + " 날짜형식이 아닙니다");
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> dates = Arrays.asList("2002-01-01", "20021122", "2022/11/01", "test");
//        List<String> results = printLocalDate(dates);
        List<String> results = printLocalDateUsingFilter(dates);

        System.out.println("====================");
        for(String result : results) {
            System.out.println(result);
        }
    }
}

package com.vincenzo.basic;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class DatetimeTest {

    public static List<LocalDate> transformToLocalDate(List<String> dateStrings) {
        // 다양한 날짜 형식을 위한 DateTimeFormatter 리스트
        List<DateTimeFormatter> formatters = Arrays.asList(
                DateTimeFormatter.ofPattern("yyyy/MM/dd"),      // YYYY/MM/DD
                DateTimeFormatter.ofPattern("MM-dd-yyyy"),      // MM-DD-YYYY
                DateTimeFormatter.ofPattern("MMpddpyyyy")       // MMpDDpYYYY
//                DateTimeFormatter.ofPattern("yyyyMMdd"),        // YYYYMMDD
//                DateTimeFormatter.ofPattern("yyyy MM dd"),      // YYYY MM DD
//                DateTimeFormatter.ofPattern("dd-MM-yyyy")       // DD-MM-YYYY (예시 추가)
        );

        List<LocalDate> localDates = new ArrayList<>();

        // 각 문자열에 대해 포매터를 순차적으로 적용하여 변환 시도
        for (String dateStr : dateStrings) {
            boolean parsedSuccessfully = false;  // 변환 성공 여부 추적

            for (DateTimeFormatter formatter : formatters) {
                try {
                    // 포매터를 적용하여 변환 시도
                    LocalDate date = LocalDate.parse(dateStr, formatter);
                    localDates.add(date);
                    parsedSuccessfully = true;
                    break;  // 성공 시 더 이상 포매터 시도할 필요 없음
                } catch (DateTimeParseException e) {
                    // 실패 시 다음 포매터로 넘어감
                }
            }

            if (!parsedSuccessfully) {
                System.out.println("Invalid date format: " + dateStr);
            }
        }

        return localDates;
    }

    public static void main(String[] args) {
        // 다양한 형식의 날짜 문자열 리스트
//        List<String> dates = Arrays.asList("2010/02/20", "11-18-2012", "20181225", "2018 12 24", "30-12-2020", "invalidDate");
        List<String> dates =  Arrays.asList("2010/02/20", "2016p 19p 12", "11-18-2012", "2018 12 24", "20130720", "invalidDate");

        // LocalDate 리스트로 변환
        List<LocalDate> localDates = transformToLocalDate(dates);

        // 변환된 LocalDate 출력
        for (LocalDate date : localDates) {
            System.out.println(date);
        }
    }
}


package com.vincenzo.basic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayToList {

    public static void ArrayToList(int[] array) {

        List<Integer> list = Arrays.stream(array)
                .boxed()
                .toList();
        // 결과 출력
        System.out.println(list);
    }

    public static void ArrayToList(double[] array) {

        List<Double> list = Arrays.stream(array)
                .boxed()
                .toList();
        // 결과 출력
        System.out.println(list);
    }

    public static void ArrayToList(float[] array) {
//        Arrays.stream() 으로 처리되는 건 int, long, double 만 되는데 이유가 있나?
        Float[] floatObject = new Float[array.length];
        for(int i = 0; i < array.length; i++) {
            floatObject[i] = array[i];
        }
        List<Float> list = Arrays.stream(floatObject)
                .collect(Collectors.toList());

        // 결과 출력
        System.out.println(list);
    }

    public static void main(String[] args) {

        int[] test1 = {1, 2, 3, 4, 5};
        ArrayToList(test1);

        double[] test2 = {1.1, 2.1, 3.1, 4.1, 5.1};
        ArrayToList(test2);

        float[] test3 = {1.11f, 2.11f, 3.11f, 4.11f, 5.11f};
        ArrayToList(test3);
    }
}

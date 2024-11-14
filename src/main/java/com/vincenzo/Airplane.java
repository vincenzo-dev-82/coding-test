package com.vincenzo;

import java.util.HashMap;
import java.util.HashSet;

class Airplane {
    public int solution(int N, String S) {
        HashMap<Integer, HashSet<Character>> reservedSeats = new HashMap<>();
        
        if (S != null && !S.isEmpty()) {
            String[] seats = S.split(" ");
            for (String seat : seats) {
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char column = seat.charAt(seat.length() - 1);
                reservedSeats.putIfAbsent(row, new HashSet<>());
                reservedSeats.get(row).add(column);
            }
        }

        int result = 0;
        for (int row = 1; row <= N; row++) {
            HashSet<Character> reserved = reservedSeats.getOrDefault(row, new HashSet<>());
            boolean bcde = !reserved.contains('B') && !reserved.contains('C') && !reserved.contains('D') && !reserved.contains('E');
            boolean defg = !reserved.contains('D') && !reserved.contains('E') && !reserved.contains('F') && !reserved.contains('G');
            boolean fghj = !reserved.contains('F') && !reserved.contains('G') && !reserved.contains('H') && !reserved.contains('J');

            if (bcde) result++;
            if (fghj) result++;
            if (!bcde && !fghj && defg) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        int result = airplane.solution(22, "1A 3C 2B 20G 5A");

        System.out.println(result);
    }
}

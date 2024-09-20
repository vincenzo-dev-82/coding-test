package com.vincenzo.programmers;

public class WaterStorage {
    public int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage = (usage * change[i] / 100) + usage;
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /**
         * 입력값 〉	5141, 500, [10, -10, 10, -10, 10, -10, 10, -10, 10, -10]
         * 기댓값 〉	-1
         */

        WaterStorage waterStorage = new WaterStorage();
        int result = waterStorage.solution(5141, 500, new int[] {10, -10, 10, -10, 10, -10, 10, -10, 10, -10});

        System.out.println(result);
    }
}

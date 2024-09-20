package com.vincenzo.programmers;

import java.util.stream.Stream;

public class VideoSolution {

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        Integer videoLenTime = transTime(video_len);
        Integer posTime = transTime(pos);
        Integer opStartTime = transTime(op_start);
        Integer opEndTime = transTime(op_end);
        Integer result = posTime;

        for(int i = 0; i < commands.length; i++) {
            if("prev".equals(commands[i])) {
                if(opStartTime <= result && opEndTime >= result) {
                    result = opEndTime;
                }
                result -= 10;
                if(result < 0) result = 0;
            } else if("next".equals(commands[i])) {
                if(opStartTime <= result && opEndTime >= result) {
                    result = opEndTime;
                }
                result += 10;
                if(10 > (videoLenTime - result)){
                    result = videoLenTime;
                }
            }

            if(opStartTime <= result && opEndTime >= result) {
                result = opEndTime;
            }
        }

        answer = convertTime(result);

        return answer;
    }

    private static int transTime(String time) {
       String[] splitTime = time.split(":");

//       Integer[] convertedTime = new Integer[2];
//       convertedTime[0] = Integer.valueOf(splitTime[0]);
//       convertedTime[1] = Integer.valueOf(splitTime[1]);

//       Integer[] convertedTime = Stream.of(splitTime).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        Integer[] convertedTime = Stream.of(splitTime).map(Integer::parseInt).toArray(Integer[]::new);
        Integer mm = convertedTime[0] * 60;
        Integer ss = convertedTime[1];

        return mm + ss;
    }

    private static String convertTime(Integer time) {
        String mm = String.valueOf(time / 60);
        String ss = String.valueOf(time % 60);

        // 1자리 숫자인 경우 앞에 0을 붙여서 "분:초" 형식으로 만듦
        if (mm.length() == 1)
            mm = "0" + mm;
        if (ss.length() == 1)
            ss = "0" + ss;

        return mm + ":" + ss;
    }

    public static void main(String[] args) {

        // "34:33", "13:00", "00:55", "02:55", ["next", "prev"]
        // 	"10:55", "00:05", "00:15", "06:55", ["prev", "next", "next"]
        /**
         * 입력값 〉	"10:55", "00:05", "00:15", "06:55", ["prev", "next", "next"]
         * 기댓값 〉	"06:55"
         */

        /**
         * 입력값 〉	"07:22", "04:05", "00:15", "04:07", ["next"]
         * 기댓값 〉	"04:17"
         */

        String video_len = "07:22";
        String pos = "04:05";
        String op_start = "00:15";
        String op_end = "04:07";

        VideoSolution solution = new VideoSolution();
        String result = solution.solution(video_len, pos, op_start, op_end, new String[]{"next"});

        System.out.println(result);
    }
}

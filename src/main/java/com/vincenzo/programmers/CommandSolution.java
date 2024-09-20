package com.vincenzo.programmers;


public class CommandSolution {

    /**
     1. 10초 전으로 이동, Prev
     2. 10초 후로 이동, Next
     3. 오프닝 건너뛰기 Jump
     **/
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        for(String command : commands) {

            switch (command) {
                case "Prev":
                    break;
                case "Next":
                    break;
                case "Jump":
                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        CommandSolution test = new CommandSolution();

        String video_len = "";
        String pos = "";
        String op_start = "";
        String op_end = "";
        String[] commands = {"", ""};
        test.solution(video_len, pos, op_start, op_end, commands);
    }

}

package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _739_DailyTemperatures {

    public static void main(String[] args) {
        _739_DailyTemperatures obj = new _739_DailyTemperatures();

        int[] tempratures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(obj.dailyTemperatures(tempratures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();

        int[] answer = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            while (stack.peek() != null && stack.peek()[0] < temperature) {
                int[] top = stack.pop();
                answer[top[1]] = i - top[1];
            }
            stack.push(new int[]{temperature, i});
        }

        //For all leftover elements, put zero as there is no higher number on their right side
        while (!stack.isEmpty()) {
            answer[stack.pop()[1]] = 0;
        }

        return answer;
    }
}

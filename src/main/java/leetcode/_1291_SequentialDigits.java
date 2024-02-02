package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1291_SequentialDigits {

    public static void main(String[] args) {
        _1291_SequentialDigits obj = new _1291_SequentialDigits();

        int low = 1000, high = 13000;
        System.out.println(obj.sequentialDigits(low, high));
    }

    private static final String MASTER = "123456789";
    public List<Integer> sequentialDigits(int low, int high) {

        int start = String.valueOf(low).length();
        int end = String.valueOf(high).length();

        List<Integer> answer = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            // why till 10 - i because let say length is 3. We are looking for 3 digit no so in start it will pick 123
            // and shift it 234 till 789.
            // So our starting point will be from 0 to 6. What is this 6 is nothing but 10 - 4, but we have strictly 10 - i
            // it will go till 10 - 3. So, it will go till 6 only not 7
            for (int j = 0; j < 10 - i; j++) {
                int val = Integer.parseInt(MASTER.substring(j, j+i));
                if (val >= low && val <= high) {
                    answer.add(val);
                }
            }
        }
        return answer;
    }
}

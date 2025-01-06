package leetcode;

import java.util.Arrays;

public class _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    public static void main(String[] args) {
        _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox obj = new _1769_MinimumNumberOfOperationsToMoveAllBallsToEachBox();

        String boxes = "110";
        System.out.println(Arrays.toString(obj.minOperations(boxes)));
    }

    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];

        int initialSum = 0;
        int boxCount = 0;

        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                boxCount++;
                // The initial sum of distances from the first box to all boxes with balls
                initialSum += i;
            }
        }

        answer[0] = initialSum;
        int boxesOnLeft = 0;

        for (int i = 1; i < boxes.length(); i++) {
            // If the previous box had a ball, it contributes to the left count
            if (boxes.charAt(i-1) == '1') {
                boxesOnLeft++;
            }
            answer[i] = answer[i-1] - (boxCount - boxesOnLeft) + boxesOnLeft;
        }
        return answer;
    }
}

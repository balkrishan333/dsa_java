package leetcode;

import java.util.Arrays;

public class _1964_FindTheLongestValidObstacleCourseAtEachPosition {

    public static void main(String[] args) {
        _1964_FindTheLongestValidObstacleCourseAtEachPosition obj = new _1964_FindTheLongestValidObstacleCourseAtEachPosition();

        int[] obstacles = {3,1,5,6,4,2};
        System.out.println(Arrays.toString(obj.longestObstacleCourseAtEachPosition(obstacles)));
    }

    /*
        Approach: Binary search

        Didn't quite understand the logic. Read the editorial

     */
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] answer = new int[obstacles.length];
        int[] lis = new int[obstacles.length];
        int lisLength = 0;

        for (int i = 0; i < obstacles.length; i++) {
            int index = findSmaller(lis, obstacles[i], lisLength);

            if (index == lisLength) {
                lisLength++;
            }

            lis[index] = obstacles[i];
            answer[i] = index+1;
        }
        return answer;
    }

    private int findSmaller(int[] lis, int target, int right) {
        int left = 0;

        while (left < right) {
            int mid = left + (right-left) /2;

            if (lis[mid] <= target) {
                left = mid +1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

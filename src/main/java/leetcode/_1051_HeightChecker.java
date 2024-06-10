package leetcode;

import java.util.Arrays;

public class _1051_HeightChecker {

    public static void main(String[] args) {
        _1051_HeightChecker obj = new _1051_HeightChecker();

        int[] heights = {5,4,3,2,1};
        System.out.println(obj.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {
        int[] heightsCopy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heightsCopy);

        int count = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heightsCopy[i] != heights[i]) {
                count++;
            }
        }
        return count;
    }
}

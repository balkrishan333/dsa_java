package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _228_SummaryRanges {

    public static void main(String[] args) {
        _228_SummaryRanges obj = new _228_SummaryRanges();

//        int[] nums = {0,2,3,4,6,8,9};
        int[] nums = {Integer.MIN_VALUE, Integer.MAX_VALUE};
        System.out.println(obj.summaryRanges(nums));
    }

    /*
        Approach : Linear search
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();

        //base condition
        if (nums.length == 0) {
            return answer;
        }

        //base condition
        if (nums.length == 1) {
            answer.add(String.valueOf(nums[0]));
            return answer;
        }

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            //if difference is more than one, that mean sequence has a gap, create a new range, else keep on iterating
            if (nums[i] -nums[i-1] != 1) {
                int range = i -1 - start;
                if (range == 0) { //if start and previous elements are same, add the element
                    answer.add(String.valueOf(nums[start]));
                } else { // else create the range
                    answer.add(nums[start] + "->"+ nums[i-1]);
                }
                start = i;
            }
        }

        //handle last few elements
        if (start < nums.length-1) {
            answer.add(nums[start] + "->" + nums[nums.length - 1]);
        } else {
            answer.add(String.valueOf(nums[start]));
        }
        return answer;
    }
}

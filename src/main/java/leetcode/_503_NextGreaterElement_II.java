package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _503_NextGreaterElement_II {

    public static void main(String[] args) {
        _503_NextGreaterElement_II obj = new _503_NextGreaterElement_II();

        int[] nums = {1,2,3,4,3};
        System.out.println(Arrays.toString(obj.nextGreaterElements(nums)));
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        Arrays.fill(res, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        /*
            Since it is a circular array, we are iterating through entire array twice. we do this by
            iterating over 2*length and then referring the index by i % length.
         */
        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                res[stack.pop()] = nums[i % len];
            }
            stack.push(i % len);
        }
        return res;
    }
}

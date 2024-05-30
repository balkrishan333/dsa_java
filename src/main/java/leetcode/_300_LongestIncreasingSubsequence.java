package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        _300_LongestIncreasingSubsequence obj = new _300_LongestIncreasingSubsequence();

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(obj.lengthOfLIS(nums));
    }

    /*
        Approach: https://www.youtube.com/watch?v=OIU8ZLC4qIQ

        As we move through elements, maintain a list of all increasing subsequences. For each incoming element, see if there exists a
        list whose last element is less than the incoming element, if yes append the element to that list. If there are multiple such
        lists, choose the one with the largest length.

        If after insertion of elements, there are multiple lists of the same size, keep the one whose last element is smallest and remove
        others. Why keep the one with the smallest element because it gives us an opportunity to squeeze in more elements.

        In the end, the list with the largest size is the answer

        During implementation, we don't need to maintain all the lists, rather we can keep track of a list to simulate the above
        behavior. Maintain a list. When the incoming element is present in the list, it won't have any impact. If the element is not
        present in the array, add it to the appropriate position, replacing the element with the higher value.

     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            //For elements that don't exist in the list, binary search returns the -ve index.
            int index = Collections.binarySearch(sequence, nums[i]);
            index = index < 0 ? -(index + 1) : index;

            if (index < sequence.size()) {
                sequence.set(index, nums[i]);
            } else {
                sequence.add(nums[i]);
            }
        }
        return sequence.size();
    }
}

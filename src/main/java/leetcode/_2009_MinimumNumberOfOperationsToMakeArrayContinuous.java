package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _2009_MinimumNumberOfOperationsToMakeArrayContinuous {

    public static void main(String[] args) {
        _2009_MinimumNumberOfOperationsToMakeArrayContinuous obj = new _2009_MinimumNumberOfOperationsToMakeArrayContinuous();

        int[] nums = {1,2,3,5,6};
        System.out.println(obj.minOperations(nums));
    }

    public int minOperations(int[] nums) {
        //1 - Remove duplicates
        Set<Integer> unique = new HashSet<>();

        for (int num : nums) {
            unique.add(num);
        }

        //2 - Create new array without duplicates and sort
        int[] newNums = new int[unique.size()];
        int index = 0;
        for (int ele : unique) {
            newNums[index++] = ele;
        }
        Arrays.sort(newNums);

        //3 - For each element consider as left, and calculate the right and check how many numbers are in range [left, right]
        int answer = calcOperations(nums, newNums);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private static int calcOperations(int[] nums, int[] newNums) {
        int j = 0; //putting j outside of loop because as left increases, right also increases and hence j. Since newNums is sorted we
        // can start from where we left in last iteration
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < newNums.length; i++) {
            int left = newNums[i];
            int right = left + nums.length - 1;

            while (j < newNums.length && newNums[j] <= right) {
                j++;
            }
            int elementsInRange = j - i;

            //nums.length is original length of array, we need to how many of those are out of range
            answer = Math.min(answer, nums.length - elementsInRange);
        }
        return answer;
    }
}

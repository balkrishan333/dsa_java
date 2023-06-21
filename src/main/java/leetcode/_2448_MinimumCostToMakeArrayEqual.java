package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _2448_MinimumCostToMakeArrayEqual {

    public static void main(String[] args) {
        _2448_MinimumCostToMakeArrayEqual obj = new _2448_MinimumCostToMakeArrayEqual();

        int[] nums = {1,3,5,2};
        int[] cost = {2,3,1,14};
        System.out.println(obj.minCost(nums, cost));
    }

    /*
        Approach: Prefix sum

        See comments inline
     */
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numsAndCost = new int[n][2];

        for (int i = 0; i < n; i++) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        //sort Arrays based on nums
        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));

        //calculate the prefix sum of cost
        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];

        for (int i = 1; i < n; i++) {
            prefixCost[i] = prefixCost[i-1] + numsAndCost[i][1];
        }

        long totalCost = 0;
        //calculate the initial cost, assuming we will be making all elements equal to first element. so calculate
        // the cost as per that
        for (int i = 1; i < n; i++) {
            totalCost += (long) (numsAndCost[i][0] - numsAndCost[0][0]) * numsAndCost[i][1];
        }
        long answer = totalCost;

        //calculate the cost for all elements (except first for which we have already done this), assuming we will be
        // making all elements equal to current element in loop
        for (int i = 1; i < n; i++) {

            //calculate the delta between current and previous element
            int gap = numsAndCost[i][0] - numsAndCost[i-1][0];

            //add the cost of moving from previous element to current element to total cost. Till
            // the previous iteration, we calculated the cost till that element, so to move to next element ideally
            // we would want to calculate the cost of each of previous element to reach current element and add that
            // but we only add cost from previous element. Why does this work? This works because total cost includes
            // cost of making all elements to previous element, so effectively all elements are now equal to previous
            // element and then using prefix sum we account for all previous elements (as prefix cost is sum of cost
            // of all previous elements)
            totalCost = totalCost + gap * prefixCost[i-1];

            //we also need to subtract the cost of elements on right of current element because total cost includes
            // cost of all those elements to make them equal to previous element. So, we multiply the gap with
            // appropriate prefix sum. subtract the cost of elements on right side of current element as total cost
            // includes cost of bringing them equal to previous element and current element is greater than previous
            // element so, we need to subtract that extra cost from total cost and that extra cost includes all the
            // element in right of current element. that's why when getting prefix cost, we subtract from total cost
            // (last element)  the cost till current element.
            totalCost = totalCost - gap * (prefixCost[n-1] - prefixCost[i-1]);
            answer = Math.min(answer, totalCost);
        }
        return answer;
    }
}

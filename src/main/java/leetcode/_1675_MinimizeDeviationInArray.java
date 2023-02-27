package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1675_MinimizeDeviationInArray {

    public static void main(String[] args) {
        _1675_MinimizeDeviationInArray obj = new _1675_MinimizeDeviationInArray();

        int[] nums = {4,1,5,20,3};
        System.out.println(obj.minimumDeviation(nums));
    }

    /*
        Complexity: We can either multiply or divide a number 2 depending on odd or ever but where to stop.
        we can get into a loop. For ex: start with 1, since it is odd multiply by 2, now its 2, since 2 is even
        divide by 2 and now are back to 1.

        Approach: Reduce to 1 operation at a time rather than both multiply and divide

        Make all odd numbers even by multiplying by 2 and adding in a Priority Queue

        Take out the max from queue, compare the deviation with minimum element and update the deviation
        if less than current deviation. Stopping criteria for loop would be, encountering the max odd element
        since we had made all elements even, when we encounter max as odd stop.

        At each step calculate the minimum.
     */
    public int minimumDeviation(int[] nums) {

        int min = Integer.MAX_VALUE;

        //reverse order to make it max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        //make all odd elements even and push to queue.
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            if ((n &1) == 1) { //if n is odd
                nums[i] = n << 1; // multiply by 2
            }

            //find out the min from the updated array
            min = Math.min(min, nums[i]);
            pq.add(nums[i]);
        }

        //calculate the initial deviation
        int deviation = pq.peek() - min;

        //stop when we see odd at top of queue
        while (pq.peek() % 2 == 0) {
            int max = pq.poll();
            deviation = Math.min(deviation, max - min);
            max = max/2;
            min = Math.min(min, max);
            pq.add(max);
        }

        return Math.min(deviation, pq.peek()-min);
    }
}

package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

@SuppressWarnings("ConstantConditions")
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
        /*
            Why this works.  Eg: [7,8,10,12,15]

            Why eliminating odd elements works. isn't multiplying odd element by 2 can change the min of array as in
            ex: above. Ans: yest min changes, but then we are dividing the elements by 2 while iterating over them
            and if this element is to be the lowest it will come back again when we devide it by 2

            but we only divide max elements by 2 not all elements then how does this element come into picture.

            if the odd element is original array does not come out to be max elements after multiplying by 2
            then it won't be considered as we need to check difference between min and max.

         */
        while (pq.peek() % 2 == 0) {
            int max = pq.poll();
            deviation = Math.min(deviation, max - min);
            max = max/2;
            min = Math.min(min, max);
            pq.add(max);
        }

        // corner case, we exited from loop because we found the largest element was odd, and we can't divide odd
        //element but this element is still the largest element in array, so we need to consider it.
        return Math.min(deviation, pq.peek()-min);
    }
}

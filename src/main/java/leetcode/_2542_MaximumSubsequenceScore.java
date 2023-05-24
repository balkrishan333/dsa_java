package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _2542_MaximumSubsequenceScore {

    public static void main(String[] args) {
        _2542_MaximumSubsequenceScore obj = new _2542_MaximumSubsequenceScore();

        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        int k =3;

        System.out.println(obj.maxScore(nums1, nums2, k));
    }

    /*
        Approach: See inline comments
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {

        //step 1: combine 2 arrays into one by creating pairs of corresponding indexes
        int[][] pairs = new int[nums1.length][2];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        //step 2: sort the pairs in descending order by elements in nums2
        Arrays.sort(pairs, (a,b) -> b[1] - a[1]);

        // step 3: start by selecting first k elements from pair. Since pairs are sorted in decreasing order, out of first k elements kth
        // is minimum
        long kElementSum = 0;
        PriorityQueue<Integer> pq = new  PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            kElementSum += pairs[i][0];
            pq.add(pairs[i][0]);
        }

        // The score of the first k pairs.
        long answer = kElementSum * pairs[k - 1][1];

        // step 4: iterate through rest of the elements in array, (we don't worry about earlier element because minimum of those we have
        // already considered), take the next element of nums2 as min and in order to consider the corresponding element from nums1, we
        // need to remove an element and that should be least of currently considered elements. We can remove least by taking top of
        // priority queue (min heap)

        for (int i = k; i < nums1.length; i++) {
            kElementSum = kElementSum - pq.poll() + pairs[i][0];
            answer = Math.max(answer, kElementSum*pairs[i][1]);

            pq.add(pairs[i][0]); // add incoming element to heap
        }
        return answer;
    }
}

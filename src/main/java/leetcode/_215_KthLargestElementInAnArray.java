package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class _215_KthLargestElementInAnArray {

    public static void main(String[] args) {
        _215_KthLargestElementInAnArray obj = new _215_KthLargestElementInAnArray();

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(obj.findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        IntStream.of(nums).forEach(maxHeap::add);

        for (int i = 0; i < k-1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    /*
        This is faster on leetcode submission
     */
    public int findKthLargest_v1(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];
    }
}

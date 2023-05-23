package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _703_KthLargestElementInAStream {

    private final PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    private final int k;
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4,5,8,2};

        _703_KthLargestElementInAStream obj = new _703_KthLargestElementInAStream(k, nums);
        System.out.println(obj.add(3));
        System.out.println(obj.add(5));
        System.out.println(obj.add(10));
        System.out.println(obj.add(9));
        System.out.println(obj.add(4));
    }

    /*
        Create a priority queue and always maintain top k elements in the PQ. Initially add all elements to PQ and then keep on removing
        them till size of queue is more than k, so that we have only k elements in PQ

        Whenever an element is added, check if it is greater than
        the shortest element (first oin PQ), remove the shortest and add incoming element and return element at top of queue.
     */
    public _703_KthLargestElementInAStream(int k, int[] nums) {
        Arrays.stream(nums).forEach(priorityQueue::add);
        this.k = k;
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
    }

    public int add(int val) {
        if (priorityQueue.size() < k) {
            priorityQueue.add(val);
            return priorityQueue.peek();
        }

        if (val < priorityQueue.peek()) {
            return priorityQueue.peek();
        }

        priorityQueue.poll();
        priorityQueue.add(val);
        return priorityQueue.peek();
    }
}

package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1481_LeastNumberOfUniqueIntegersAfter_K_Removals {

    public static void main(String[] args) {
        _1481_LeastNumberOfUniqueIntegersAfter_K_Removals obj = new _1481_LeastNumberOfUniqueIntegersAfter_K_Removals();

        int[] arr = {4,3,1,1,3,3,2};
        int k = 3;
        System.out.println(obj.findLeastNumOfUniqueInts(arr, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        //count frequency of each element
        Map<Integer, Integer> frequencies = new HashMap<>();
        for(int element : arr) {
            frequencies.merge(element, 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(frequencies.values());
        int elementsRemoved = 0;

        while (!pq.isEmpty()) {
            if (pq.peek() + elementsRemoved > k) {
                return pq.size();
            }
            elementsRemoved += pq.poll();
        }
        return 0;
    }
}

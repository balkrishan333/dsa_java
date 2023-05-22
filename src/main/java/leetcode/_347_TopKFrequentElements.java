package leetcode;

import java.util.*;

public class _347_TopKFrequentElements {

    public static void main(String[] args) {
        _347_TopKFrequentElements obj = new _347_TopKFrequentElements();

        int[] nums = {1,1,1,2,2,3};
        int k =2;
        int[] res = obj.topKFrequent(nums, k);
        System.out.println(Arrays.toString(res));
    }

    /*
        Approach:
        1. Count frequency of each element in array
        2. Push all element in PriorityQueue with comparison set to reverse order
        3. Before putting the element in PQ, wrap the element and its count in custom class and implement its comparable method to compare
         on count of elements because we need frequency by count.
     */
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        //count frequency of each element
        for(int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        //PQ set to poll in reverse order
        PriorityQueue<ElementCountPair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new ElementCountPair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        //poll top k elements
        for(int i = 0; i < k ; i++) {
            res[i] = pq.poll().element;
        }

        return res;
    }

    //class with comparator set on frequency of element
    static class ElementCountPair implements Comparable<ElementCountPair> {
        int element;
        int count;

        public ElementCountPair(int element, int count) {
            this.element = element;
            this.count = count;
        }

        public int compareTo(ElementCountPair other) {
            return Integer.compare(this.count, other.count);
        }
    }
}

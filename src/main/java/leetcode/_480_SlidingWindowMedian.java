package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class _480_SlidingWindowMedian {

    public static void main(String[] args) {
        _480_SlidingWindowMedian obj =
                new _480_SlidingWindowMedian();

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(obj.medianSlidingWindow(nums, k)));
    }

    /*
        Approach: Maintain 2 maps (Treemaps as w need to keep elements sorted, as sorting is a requirement for median calculation)
        1. left map (maxHeap behavior) - contains smaller half of elements - sorting in reverse order
        2. right map (minHeap behavior) - contains larger half of elements
        3. Maintain size variables for both maps to keep track of number of elements in each
        4. For each new element, add to appropriate map based on value
        5. Remove element going out of window from appropriate map
        6. Rebalance maps to ensure size property (left can have at most 1 more element than right)
        7. Calculate median based on sizes of maps
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] answer = new double[n-k+1];

        TreeMap<Integer, Integer> left = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> right = new TreeMap<>();

        int leftSize = 0;
        int rightSize = 0;

        for (int i = 0; i < n; i++) {

            if (left.isEmpty() || nums[i] <= left.firstKey()) {
                left.merge(nums[i],1, Integer::sum);
                leftSize++;
            } else {
                right.merge(nums[i],1, Integer::sum);
                rightSize++;
            }

            if (i >=k ) {
                int toRemove = nums[i - k];
                if (left.containsKey(toRemove)) {
                    remove(left, toRemove);
                    leftSize--;
                } else {
                    remove(right, toRemove);
                    rightSize--;
                }
            }

            while (leftSize > rightSize +1) {
                int val = left.firstKey();
                add(right, val);
                remove(left, val);
                rightSize++;
                leftSize--;
            }

            while (rightSize > leftSize) {
                int val = right.firstKey();
                add(left, val);
                remove(right, val);
                rightSize--;
                leftSize++;
            }

            if (i >= k -1) {
                if (k %2 ==0) {
                    answer[i - k +1] = (double)left.firstKey() / 2.0 + (double)right.firstKey() /2.0;
                } else {
                    answer[i - k +1] = (double)left.firstKey();
                }
            }
        }
        return answer;
    }

    private void remove(TreeMap<Integer, Integer> map, int val) {
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) {
            map.remove(val);
        }
    }

    private void add(TreeMap<Integer, Integer> map, int val) {
        map.merge(val, 1, Integer::sum);
    }
}

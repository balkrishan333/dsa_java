package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _786_KTH_SmallestPrimeFraction {

    public static void main(String[] args) {
        _786_KTH_SmallestPrimeFraction obj = new _786_KTH_SmallestPrimeFraction();

        int[] arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction(arr, k)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a-> a[0]));

        int j = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(new double[]{-1.0 * arr[i]/arr[j], i, j});
        }

        while (k > 1 && !minHeap.isEmpty()) {
            double[] top = minHeap.poll();
            int numerator = (int)top[1];
            int denominator = (int)top[2];

            denominator--; // next denominator to consider

            if (denominator > numerator) {
                minHeap.offer(new double[]{-1.0 * arr[numerator]/arr[denominator], numerator, denominator});
            }
        }
        double[] answer = minHeap.poll();
        return new int[]{(int)answer[1], (int)answer[2]};
    }
}

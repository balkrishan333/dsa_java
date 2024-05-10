package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _786_KTH_SmallestPrimeFraction {

    public static void main(String[] args) {
        _786_KTH_SmallestPrimeFraction obj = new _786_KTH_SmallestPrimeFraction();

        int[] arr = {1,7};
        int k = 1;
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction(arr, k)));
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> minHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        int j = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
            minHeap.offer(new double[]{-1.0 * arr[i]/arr[j], i, j});
        }

        while (k > 1 && !minHeap.isEmpty()) {
            double[] top = minHeap.poll();
            int numeratorIndex = (int)top[1];
            int denominatorIndex = (int)top[2];

            denominatorIndex--; // next denominatorIndex to consider

            if (denominatorIndex > numeratorIndex) {
                minHeap.offer(new double[]{-1.0 * arr[numeratorIndex]/arr[denominatorIndex], numeratorIndex, denominatorIndex});
            }
            k--;
        }
        double[] answer = minHeap.poll();
        return new int[]{arr[(int)answer[1]], arr[(int)answer[2]]};
    }
}

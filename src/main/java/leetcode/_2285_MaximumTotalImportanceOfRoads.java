package leetcode;

import java.util.Arrays;

public class _2285_MaximumTotalImportanceOfRoads {

    public static void main(String[] args) {
        _2285_MaximumTotalImportanceOfRoads obj = new _2285_MaximumTotalImportanceOfRoads();

        int n = 5;
        int[][] rods = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(obj.maximumImportance(n, rods));
    }

    public long maximumImportance(int n, int[][] roads) {
        long[] degree = new long[n];

        for (int[] edge : roads) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Arrays.sort(degree);

        long value = 1;
        long totalImportance = 0;
        for (long d : degree) {
            //in case 2 nodes have the same degree, we can assign higher value to anyone of them, because to calculate the sum values
            // will be added the same number of times, hence a final result will not be impacted.
            totalImportance += (value * d);
            value++;
        }
        return totalImportance;
    }
}

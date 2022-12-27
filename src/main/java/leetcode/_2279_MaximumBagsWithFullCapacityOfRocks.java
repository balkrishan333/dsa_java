package leetcode;

import java.util.Arrays;

public class _2279_MaximumBagsWithFullCapacityOfRocks {

    public static void main(String[] args) {
        _2279_MaximumBagsWithFullCapacityOfRocks obj = new _2279_MaximumBagsWithFullCapacityOfRocks();

        int[] capacity = {2, 3, 4, 5};
        int[] rocks = {1, 2, 4, 4};
        int additionalRocks = 2;
        System.out.println(obj.maximumBags(capacity, rocks, additionalRocks));
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] diff = new int[capacity.length];
        long totalDiff = 0;

        for (int i = 0; i < capacity.length; i++) {
            diff[i] = capacity[i] - rocks[i];
            totalDiff += diff[i];
        }

        if (totalDiff <= additionalRocks) {
            return capacity.length;
        }

        Arrays.sort(diff);
        int answer = 0;

        for (int i = 0; i < diff.length; i++) {
            if (diff[i] == 0) {
                answer++;
            } else {
                if(additionalRocks >= diff[i]) {
                    additionalRocks = additionalRocks - diff[i];
                    answer++;
                }
            }
        }
        return answer;
    }
}

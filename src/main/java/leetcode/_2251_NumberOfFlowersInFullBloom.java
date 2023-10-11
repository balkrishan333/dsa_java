package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _2251_NumberOfFlowersInFullBloom {

    public static void main(String[] args) {
        _2251_NumberOfFlowersInFullBloom obj = new _2251_NumberOfFlowersInFullBloom();

        int[][] flowers = {{1,6},{3,7},{9,12},{4,13}};
        int[] people = {2,3,7,11};
        System.out.println(Arrays.toString(obj.fullBloomFlowers(flowers, people)));
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();

        for (int[] flower: flowers) {
            starts.add(flower[0]);
            ends.add(flower[1] + 1);
        }

        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];

        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            int i = binarySearch(starts, person);
            int j = binarySearch(ends, person);
            ans[index] = i - j;
        }

        return ans;
    }

    public int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < arr.get(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

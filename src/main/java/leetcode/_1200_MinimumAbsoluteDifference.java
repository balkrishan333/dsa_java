package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200_MinimumAbsoluteDifference {

    public static void main(String[] args) {
        _1200_MinimumAbsoluteDifference obj = new _1200_MinimumAbsoluteDifference();

        int[] arr = {4,2,1,3};

        System.out.println(obj.minimumAbsDifference(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            if (diff == min) {
                result.add(List.of(arr[i-1], arr[i]));
            } else if (diff < min) {
                result.clear();
                min = diff;
                result.add(List.of(arr[i-1], arr[i]));
            }
        }
        return result;
    }
}

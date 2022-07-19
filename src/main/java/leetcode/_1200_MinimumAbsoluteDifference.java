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
                addToList(arr, result, i);
            } else if (diff < min) {
                result.clear();
                min = diff;

                addToList(arr, result, i);
            }
        }
        return result;
    }

    private void addToList(int[] arr, List<List<Integer>> result, int i) {
        List<Integer> l1 = new ArrayList<>();
        l1.add(arr[i-1]);
        l1.add(arr[i]);

        result.add(l1);
    }
}

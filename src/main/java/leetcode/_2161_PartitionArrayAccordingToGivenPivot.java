package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2161_PartitionArrayAccordingToGivenPivot {

    public static void main(String[] args) {
        _2161_PartitionArrayAccordingToGivenPivot obj =
                new _2161_PartitionArrayAccordingToGivenPivot();

        int[] nums = {9,12,5,10,14,3,10};
        int pivot = 10;
        System.out.println(Arrays.toString(obj.pivotArray(nums, pivot)));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessThanPivot = new ArrayList<>();
        List<Integer> equalToPivot = new ArrayList<>();
        List<Integer> moreThanPivot = new ArrayList<>();

        for (int num : nums) {
            if (num < pivot) {
                lessThanPivot.add(num);
            } else if (num == pivot) {
                equalToPivot.add(num);
            } else {
                moreThanPivot.add(num);
            }
        }

        lessThanPivot.addAll(equalToPivot);
        lessThanPivot.addAll(moreThanPivot);

        return lessThanPivot.stream().mapToInt(Integer::intValue).toArray();
    }
}

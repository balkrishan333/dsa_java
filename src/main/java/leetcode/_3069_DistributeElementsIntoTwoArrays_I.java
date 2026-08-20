package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3069_DistributeElementsIntoTwoArrays_I {

    static void main() {
        _3069_DistributeElementsIntoTwoArrays_I obj = new _3069_DistributeElementsIntoTwoArrays_I();

        int[] nums = {5,4,3,8};
        System.out.println(Arrays.toString(obj.resultArray(nums)));
    }

    public int[] resultArray(int[] nums) {
        int len = nums.length;

        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        arr1.add(nums[0]);
        arr2.add(nums[1]);

        for (int i = 2; i < len ; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        arr1.addAll(arr2);

        int[] answer = new int[len];
        for (int i = 0; i < arr1.size(); i++) {
            answer[i] = arr1.get(i);
        }
        return answer;
    }
}

package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MaximumErasureValue_1695 {

    public static void main(String[] args) {
        MaximumErasureValue_1695 obj = new MaximumErasureValue_1695();

//        int[] nums = {5,2,1,2,5,2,1,2,5};
//        int[] nums = {4,2,4,5,6};
        int [] nums = {449,154,934,526,429,732,784,909,884,805,635,660,742,209,742,272,669,449,766,904,698,434,280,332,
                876,200,333,464,12,437,269,355,622,903,262,691,768,894,929,628,867,844,208,384,644,511,908,792,56,872,
                275,598,633,502,894,999,788,394,309,950,159,178,403,110,670,234,119,953,267,634,330,410,137,805,317,
                470,563,900,545,308,531,428,526,593,638,651,320,874,810,666,180,521,452,131,201,915,502,765,17,577,821,
                731,925,953,111,305,705,162,994,425,17,140,700,475,772,385,922,159,840,367,276,635,696,70,744,804,63,
                448,435,242,507,764,373,314,140,825,34,383,151,602,745};

//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.merge(nums[i], 1, Integer::sum);
//        }
//
//        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toList());
//        System.out.println(collect);

        System.out.println(obj.maximumUniqueSubarray(nums));

    }

    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> indexes = new HashMap<>();

        int start =0, end =0;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            Integer index = indexes.get(nums[i]);

            if (index != null && index >= start) {
                result = Math.max(result, sum);
                sum = sum - Arrays.stream(nums, start, index+1).sum();
                start = index+1;
            }
            sum = sum + nums[i];

            end = i;
            indexes.put(nums[i], i);
        }
        return Math.max(result, Arrays.stream(nums, start, end+1).sum());
    }
}

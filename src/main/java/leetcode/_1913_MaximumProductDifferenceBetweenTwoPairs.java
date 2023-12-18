package leetcode;

public class _1913_MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {
        _1913_MaximumProductDifferenceBetweenTwoPairs obj = new _1913_MaximumProductDifferenceBetweenTwoPairs();

        int[] nums = {4,2,5,9,7,4,8};
        System.out.println(obj.maxProductDifference(nums));
    }

    public int maxProductDifference(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else {
                secondMax = Math.max(secondMax, num);
            }

            if (num < min) {
                secondMin = min;
                min = num;
            } else {
                secondMin = Math.min(secondMin, num);
            }
        }
        return (max * secondMax) - (min * secondMin);
    }
}

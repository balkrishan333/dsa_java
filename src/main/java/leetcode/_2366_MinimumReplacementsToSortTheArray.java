package leetcode;

public class _2366_MinimumReplacementsToSortTheArray {

    public static void main(String[] args) {
        _2366_MinimumReplacementsToSortTheArray obj = new _2366_MinimumReplacementsToSortTheArray();

        int[] nums = {12,9,7,6,17,19,21};
        System.out.println(obj.minimumReplacement(nums));
    }

    public long minimumReplacement(int[] nums) {
        long answer = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            // No need to break if they are already in order.
            if (nums[i] <= nums[i + 1]) {
                continue;
            }

            // Count how many elements are made from breaking nums[i]. This way of calculation will handle whether
            // nums[i] is divisible as nums[i + 1] or not
            long numElements = (long)(nums[i] + nums[i + 1] - 1) / (long)nums[i + 1];

            // It requires numElements - 1 replacement operations, since 1 less split is required to get no. of elements
            answer += numElements - 1;

            // Maximize nums[i] after replacement.
            nums[i] = nums[i] / (int)numElements;
        }
        return answer;
    }
}

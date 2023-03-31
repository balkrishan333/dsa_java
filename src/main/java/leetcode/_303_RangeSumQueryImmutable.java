package leetcode;

public class _303_RangeSumQueryImmutable {

    private int[] sum;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        _303_RangeSumQueryImmutable obj = new _303_RangeSumQueryImmutable(nums);
        System.out.println(obj.sumRange(0,2));
        System.out.println(obj.sumRange(2,5));
        System.out.println(obj.sumRange(0,5));
    }

    /*
        Approach:

        Create new array where each element is sum of all previous elements + current element. First element is
        equal to first element in given array

        To find sum of range, find the sum at right index and subtract from it sum of element which are on left of
        given range left.
     */
    public _303_RangeSumQueryImmutable(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int answer = sum[right];
        if (left == 0) {
            return answer;
        }
        //subtract the sum of element which are before left
        return answer - sum[left-1];
    }
}

package leetcode;

public class _268_MissingNumber {

    public static void main(String[] args) {
        _268_MissingNumber obj = new _268_MissingNumber();

        int[] nums = {3,0,1};
        System.out.println(obj.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int expectedSum = len *(len+1)/2;

        for (int num : nums) {
            expectedSum -= num;
        }
        return expectedSum;
    }
}

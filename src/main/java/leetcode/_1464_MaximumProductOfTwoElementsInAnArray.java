package leetcode;

public class _1464_MaximumProductOfTwoElementsInAnArray {

    public static void main(String[] args) {
        _1464_MaximumProductOfTwoElementsInAnArray obj = new _1464_MaximumProductOfTwoElementsInAnArray();

        int[] nums = {2,2,1,8,1,5,4,5,2,10,3,6,5,2,3};
        System.out.println(obj.maxProduct(nums));
    }

    /*
        Approach: At each step, find 2 largest elements from 3: max1, max2 and curr
     */
    public int maxProduct(int[] nums) {
        int max1 = nums[0];
        int max2 = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int curr = nums[i];

            if (curr > max1 && curr > max2) {
                if (max1 < max2) {
                    max1 = curr;
                } else {
                    max2 = curr;
                }
            } else if (curr > max1){
                max1 = curr;
            } else if (curr > max2) {
                max2 = curr;
            }
        }
        return (max1-1) * (max2-1);
    }
}

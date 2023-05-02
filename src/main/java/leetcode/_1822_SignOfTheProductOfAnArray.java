package leetcode;

public class _1822_SignOfTheProductOfAnArray {

    public static void main(String[] args) {
        _1822_SignOfTheProductOfAnArray obj = new _1822_SignOfTheProductOfAnArray();

        int[] nums = {-1,-2,-3,-4,3,2,1};
        System.out.println(obj.arraySign(nums));
    }

    public int arraySign(int[] nums) {
        int negatives = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }

            if (num < 0) {
                negatives++;
            }
        }

        return negatives % 2 == 0 ? 1 : -1;
    }
}

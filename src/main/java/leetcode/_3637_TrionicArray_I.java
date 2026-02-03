package leetcode;

public class _3637_TrionicArray_I {

    public static void main(String[] args) {
        _3637_TrionicArray_I obj =
                new _3637_TrionicArray_I();

        int[] nums = {1,3,5,4,2,6};
        System.out.println(obj.isTrionic(nums));
    }

    public boolean isTrionic(int[] nums) {
        if (nums[0] > nums[1]) {
            return false;
        }
        int n = nums.length;
        int i = 1;
        while (i < n && nums[i-1] < nums[i]) {
            i++;
        }
        int p = i-1;

        while (i < n && nums[i-1] > nums[i]) {
            i++;
        }
        int q = i-1;

        while (i < n && nums[i-1] < nums[i]) {
            i++;
        }
        int last = i-1;

        return p != q && q != last && last == n-1 && p > 0;
    }
}

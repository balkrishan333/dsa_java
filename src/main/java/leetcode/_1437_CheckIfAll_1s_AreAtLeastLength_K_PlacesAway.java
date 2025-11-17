package leetcode;

public class _1437_CheckIfAll_1s_AreAtLeastLength_K_PlacesAway {

    public static void main(String[] args) {
        _1437_CheckIfAll_1s_AreAtLeastLength_K_PlacesAway obj =
                new _1437_CheckIfAll_1s_AreAtLeastLength_K_PlacesAway();

        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        System.out.println(obj.kLengthApart(nums, k));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}

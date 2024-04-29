package leetcode;

public class _2997_MinimumNumberOfOperationsToMakeArrayXOREqualToK {

    public static void main(String[] args) {
        _2997_MinimumNumberOfOperationsToMakeArrayXOREqualToK obj =
                new _2997_MinimumNumberOfOperationsToMakeArrayXOREqualToK();

        int[] nums = {2,1,3,4};
        int k = 1;
        System.out.println(obj.minOperations(nums, k));
    }

    public int minOperations(int[] nums, int k) {
        int exoredValue = 0;

        //calculate the exored value of the array
        for(int num : nums) {
            exoredValue ^= num;
        }

        //exor of the array and k will give the target value. No of set bits of this target value will be the answer.
        int target = exoredValue ^ k;
        return Integer.bitCount(target);
    }
}

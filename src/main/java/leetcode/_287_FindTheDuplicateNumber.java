package leetcode;

public class _287_FindTheDuplicateNumber {

    public static void main(String[] args) {
        _287_FindTheDuplicateNumber obj = new _287_FindTheDuplicateNumber();

        int[] nums = {1,3,4,2,2};
        System.out.println(obj.findDuplicate(nums));
    }

    /*
        Approach: Consider values in array as indexes (we can do this due to constraints in the problem which state numbers are n+1 and
        within range 1-n, so max number will be n and since array has n+1 elements, index numbered "n" will be present in array)

        Now problem reduces to, if we visit the same index twice we know the duplicate number but how do we know if we visited the index
        before or not. For that, as we visit an index, we mark the number in array as -ve. So if we visit that number again we know
        number will be -ve there and for all other cases number will be +ve

        So that number is answer.
     */
    public int findDuplicate(int[] nums) {
        int result = -1;
        for(int num : nums) {
            if (nums[Math.abs(num)] < 0) {
                result = Math.abs(num);
                break;
            }
            nums[Math.abs(num)] *= -1;
        }
        return result;
    }
}

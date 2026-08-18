package leetcode;

public class _3471_FindTheLargestAlmostMissingInteger {

    public static void main(String[] args) {
        _3471_FindTheLargestAlmostMissingInteger obj = new _3471_FindTheLargestAlmostMissingInteger();

        int[] nums = {3,9,2,1,7};
        int k = 3;
        System.out.println(obj.largestInteger(nums, k));
    }

    public int largestInteger(int[] nums, int k) {
        int len = nums.length;

        int answer = -1;
        if (k == len) { //there is only 1 sub-array
            for (int num : nums) {
                answer = Math.max(answer, num);
            }
            return answer;
        }

        int[] count = new int[51];
        for (int i = 0; i < len; i++) {
            count[nums[i]]++;
        }

        if (k == 1) {
            for (int i = 50; i >= 0 ; i--) {
                if (count[i] == 1) {
                    return i;
                }
            }
        }

        if (count[nums[0]] == 1) {
            answer = Math.max(answer, nums[0]);
        }

        if (count[nums[len-1]] == 1) {
            answer = Math.max(answer, nums[len-1]);
        }

        return answer;
    }
}

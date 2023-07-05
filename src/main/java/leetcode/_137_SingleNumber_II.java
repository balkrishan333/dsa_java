package leetcode;

public class _137_SingleNumber_II {

    public static void main(String[] args) {
        _137_SingleNumber_II obj = new _137_SingleNumber_II();

        int[] nums = {2,2,3,2};
        System.out.println(obj.singleNumber(nums));
    }

    /*
        Approach; Bit Manipulation

        Requirement is to use constant space. Only way to use constant space is using Bit manipulation

        No. of 1's in binary representation of a number is different from any other number. So, we calculate the number of 1's for each
        number and take mod of the sum to make sure we set the sum to zero (because we want to ignore all number which occurs 3 times).
        If a number occurs only once, count of its 1 bit will not be zero after taking mod 3. So, we consider this bit by left shifting
        the bit to its right place.

        We count the number of 1 bit in each number for each bit position
     */
    public int singleNumber(int[] nums) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if (sum != 0) {
                answer |= sum << i;
            }
        }
        return answer;
    }
}

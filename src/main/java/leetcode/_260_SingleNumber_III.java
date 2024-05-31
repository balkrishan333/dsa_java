package leetcode;

import java.util.Arrays;

public class _260_SingleNumber_III {

    public static void main(String[] args) {
        _260_SingleNumber_III obj = new _260_SingleNumber_III();

        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(obj.singleNumber(nums)));
    }

    /*
        Approach:

        One important point is that by XORing all the numbers, we actually get the XOR of the two target numbers (because XORing two
        duplicate numbers always results in 0). Consider the XOR result of the two target numbers; if some bit of the XOR result is 1,
        it means that the two target numbers differ at that location.

        Let’s say the at the ith bit, the two desired numbers differ from each other. which means one number has bit i equaling: 0, the
        other number has bit i equaling 1.

        Thus, all the numbers can be partitioned into two groups according to their bits at location i.
        the first group consists of all numbers whose bits at i is 0.
        the second group consists of all numbers whose bits at i is 1.

        Notice that, if a duplicate number has bit i as 0, then, two copies of it will belong to the first group. Similarly, if a
        duplicate number has bit i as 1, then, two copies of it will belong to the second group.

        by XoRing all numbers in the first group, we can get the first number.
        by XoRing all numbers in the second group, we can get the second number.
     */
    public int[] singleNumber(int[] nums) {
        int xor = nums[0];

        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        int bit = xor & ~(xor -1); //Finds the right most set bit. After this operation result will have all zero except 1 bit.

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & bit) > 0) {
                num1 = num ^ num1;
            }else {
                num2 = num ^ num2;
            }
        }
        return new int[]{num1, num2};
    }
}

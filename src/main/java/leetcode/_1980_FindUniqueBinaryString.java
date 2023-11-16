package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _1980_FindUniqueBinaryString {

    public static void main(String[] args) {
        _1980_FindUniqueBinaryString obj = new _1980_FindUniqueBinaryString();

        String[] nums = {"000", "111","011","001"};
        System.out.println(obj.findDifferentBinaryString(nums));
    }

    public String findDifferentBinaryString(String[] nums) {
        int len = nums[0].length();

        List<String> strings = new LinkedList<>(Arrays.asList(nums));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append("0");
        }

        int count = 0;
        String val = sb.toString();
        String answer = null;
        while (count <= nums.length) {
            if (!strings.contains(val)) {
                answer = val;
                break;
            }
            int intVal = Integer.valueOf(val, 2);
            val = String.format("%"+len+"s", Integer.toBinaryString(intVal + 1)).replace(' ', '0');
            count++;
        }
        return answer;
    }

    /*
        Following solution is from Leetcode editorial

        Check the ith character of ith string and append opposite of it to the answer.

        See Cantor's Diagonal Argument for more details how this works
     */
    public String findDifferentBinaryString_leetcode(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<nums.length; i++){
            sb.append(nums[i].charAt(i) == '0' ? "1" : "0");
        }

        return new String(sb);
    }
}

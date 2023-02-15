package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _989_AddToArrayFormOfInteger {

    public static void main(String[] args) {
        _989_AddToArrayFormOfInteger obj = new _989_AddToArrayFormOfInteger();

        int[] num = {9,9};
        int k = 1;
        System.out.println(obj.addToArrayForm(num, k));
    }

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> answer = new ArrayList<>();

        for (int val : num) {
            answer.add(val);
        }

        if (k == 0) {
            return answer;
        }

        int index = answer.size()-1;
        int carry = 0;

        while (k > 0 || index >= 0) {
            int sum = carry;
            sum += k % 10;
            if (index >= 0) {
                sum += answer.get(index);
                answer.remove(index);
            }

            answer.add(Math.max(index, 0), sum%10);
            index--;
            carry = sum/10;
            k = k/10;
        }
        if (carry > 0) {
            answer.add(0, carry);
        }
        return answer;
    }
}

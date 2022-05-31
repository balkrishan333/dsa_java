package leetcode;

import java.util.stream.Stream;

public class CheckIfStringContainsAllBinaryCodes_1461 {

    public static void main(String[] args) {
        CheckIfStringContainsAllBinaryCodes_1461 obj = new CheckIfStringContainsAllBinaryCodes_1461();

        String s = "00110";
        int k =2;
        System.out.println(obj.hasAllCodes(s, k));
    }

    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) {
            return false;
        }

        int max = 1 << k;
        boolean[] exists = new boolean[max];

        for (int i = 0; i <= s.length() - k; i++) {
            String str = s.substring(i, i+k);
            int val = Integer.valueOf(str, 2);

            if (val <= max) {
                exists[val] = true;
            }
        }

        for (int i = 0; i < exists.length; i++) {
            if (!exists[i]) {
                return false;
            }
        }
        return true;
    }
}

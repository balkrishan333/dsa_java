package leetcode;

import java.util.Arrays;

public class _3713_LongestBalancedSubstring_I {

    public static void main(String[] args) {
        _3713_LongestBalancedSubstring_I obj =
                new _3713_LongestBalancedSubstring_I();

        String s = "abbac";
        System.out.println(obj.longestBalanced(s));
    }

    public int longestBalanced(String s) {
        int ans = 0;
        int n = s.length();
        int[] count = new int[26];

        for (int i = 0; i < n; i++) {
            Arrays.fill(count, -1);
            for (int j = i; j < n; j++) {
                int ch = s.charAt(j) - 'a';
                count[ch]++;

                boolean flag = true;
                for (int k = 0; k < 26; k++) {
                    if (count[k] != -1 && count[k] != count[ch]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}

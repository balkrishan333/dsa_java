package leetcode;

public class _91_DecodeWays {

    public static void main(String[] args) {
        _91_DecodeWays obj = new _91_DecodeWays();

        String s = "226";
        System.out.println(obj.numDecodings(s));
    }

    /*
        Approach : Dynamic Programming
     */
    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.startsWith("0")) {
            return 0;
        }

        int[] dp = new int[s.length()+1];
        dp[0] = 1;   //Empty string cn be decoded in one way only
        dp[1] = 1;  //String of len 1 can be decoded in 1 way one. First char can't be zero and same has been handled in above condition

        for (int i = 2; i <= s.length(); i++) {
            int lengthOne = Integer.parseInt(s.substring(i-1, i));
            int lengthTwo = Integer.parseInt(s.substring(i-2, i));

            if (lengthOne >=1 && lengthOne <=9) {
                dp[i] += dp[i-1];
            }

            if (lengthTwo >= 10 && lengthTwo <=26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}

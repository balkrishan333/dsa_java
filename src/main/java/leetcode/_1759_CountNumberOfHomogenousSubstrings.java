package leetcode;

public class _1759_CountNumberOfHomogenousSubstrings {

    public static void main(String[] args) {
        _1759_CountNumberOfHomogenousSubstrings obj = new _1759_CountNumberOfHomogenousSubstrings();

        String s = "abbcccaa";
        System.out.println(obj.countHomogenous(s));
    }

    /*
        We count the streak of homogeneous characters. No of homogeneous substrings are equal to length streak.

        Total possible strings are equal to : n*(n+1)/2

        Rather than this calculation, we iterate over every character and find the streak length and take that. Trick is since we are
        iterating over each character, and we check streak length on each character, effectively  we are calculating the above formula

     */
    public int countHomogenous(String s) {
        int ans = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                currStreak++;
            } else {
                currStreak = 1;
            }

            ans = (ans + currStreak) % MOD;
        }

        return ans;
    }
}

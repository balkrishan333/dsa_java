package leetcode;

public class LongestPalindromicSubstring_5 {

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 obj = new LongestPalindromicSubstring_5();

        String s = "aacabdkacaa";
        System.out.println(obj.longestPalindrome_v3(s));
    }

    /*
        1. Start from middle and expand in both directions
        2. check for both odd length and even length palindromes
     */
    public String longestPalindrome_v3(String s) {

        int length, start =0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int odd = expand(s, i, i); //middle is i --> odd len palindrome
            int even = expand(s, i, i+1); // (middle is i,i+1) --> even len palindrome

            length = Math.max(odd, even);

            if (length > end - start) {
                start = i - (length-1)/2;
                end = i + (length/2);
            }
        }
        return s.substring(start, end+1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //from middle move left to left and right to right
            left--;
            right++;
        }
        return right-left-1;
    }

    public String longestPalindrome(String s) {
        if (s.length() <2) {
            return s;
        }

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 0;
        int start =0;

        for (int i = n-1; i >=0; i--) {
            for (int j = i; j < n; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1]);

                if (dp[i][j]) {
                    if (j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    //does not work
    //fails following case: "aacabdkacaa"
    public String longestPalindrome_v2(String s) {
        for(int i =0,j=s.length()-1; i<=j; i++,j--) {
            if(s.charAt(i) != s.charAt(j)) {
                String s1 = longestPalindrome(s.substring(i,j)); //exclude last character
                String s2 = longestPalindrome(s.substring(i+1,j+1)); //exclude first character

                if(s1.length() > s2.length()) {
                    return s1;
                }
                return s2;
            }
        }
        return s;
    }
}

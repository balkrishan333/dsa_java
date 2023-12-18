package leetcode;

public class _5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        _5_LongestPalindromicSubstring obj = new _5_LongestPalindromicSubstring();

        String s = "nitin";
        System.out.println(obj.longestPalindrome(s));
    }

    /*
        1. Start from middle and expand in both directions
        2. check for both odd length and even length palindromes
     */
    public String longestPalindrome(String s) {

        int length, start =0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int odd = expand(s, i, i); //middle is i --> odd len palindrome
            int even = expand(s, i, i+1); // (middle is i,i+1) --> even len palindrome

            length = Math.max(odd, even);

            if (length > end - start) {
                //(length -1) is required to accommodate for even length string. When we start calculating even length palindrome, we
                // start from i and use i+1 as right but we do calculation with i only. So we have 1 extra char on right for even length
                // palindrome.
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
        return right-left-1; // simplification of (right - 1) - (left +1) + 1
    }
}

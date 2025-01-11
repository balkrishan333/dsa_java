package leetcode;

public class _1400_Construct_K_PalindromeStrings {

    public static void main(String[] args) {
        _1400_Construct_K_PalindromeStrings obj = new _1400_Construct_K_PalindromeStrings();

        String s = "annabelle";
        int k = 2;
        System.out.println(obj.canConstruct(s, k));
    }

    public boolean canConstruct(String s, int k) {

        if (s.length() < k) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i)- 'a']++;
        }

        int charsWithOddCount = 0;
        for (int i = 0; i < 26; i++) {
            if(charCount[i] % 2 == 1) {
                charsWithOddCount++;
            }
        }

        return charsWithOddCount <= k;
    }
}

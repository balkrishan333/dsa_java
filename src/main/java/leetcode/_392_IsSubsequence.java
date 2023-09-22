package leetcode;

public class _392_IsSubsequence {

    public static void main(String[] args) {
        _392_IsSubsequence obj = new _392_IsSubsequence();

        String s = "abc", t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t));
    }

    public boolean isSubsequence(String s, String t) {

        if (s.isBlank()) {
            return true;
        }

        for (int i = 0, j= 0; i < s.length() && j < t.length(); j++) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            if (i == s.length()) {
                return true;
            }
        }
        return false;
    }
}

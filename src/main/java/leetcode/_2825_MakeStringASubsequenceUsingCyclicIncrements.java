package leetcode;

public class _2825_MakeStringASubsequenceUsingCyclicIncrements {

    public static void main(String[] args) {

        _2825_MakeStringASubsequenceUsingCyclicIncrements obj = new _2825_MakeStringASubsequenceUsingCyclicIncrements();

        String str1 = "abc";
        String str2 = "ad";
        System.out.println(obj.canMakeSubsequence(str1, str2));
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1 == null || str2 == null || str1.isEmpty()) {
            return false;
        }

        if (str2.isEmpty()) {
            return true;
        }

        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j) || getCyclicChar(str1.charAt(i)) == str2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == str2.length();
    }

    private char getCyclicChar(char ch) {
        return (char) ((ch - 'a' + 1) % 26 + 'a');
    }
}

package leetcode;

public class _2108_FindFirstPalindromicStringInTheArray {

    public static void main(String[] args) {
        _2108_FindFirstPalindromicStringInTheArray obj = new _2108_FindFirstPalindromicStringInTheArray();

        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(obj.firstPalindrome(words));
    }

    public String firstPalindrome(String[] words) {

        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        char[] charArr = word.toCharArray();
        for (int i = 0, j = word.length()-1; i <= j; i++,j--) {
            if (charArr[i] != charArr[j]) {
                return false;
            }
        }
        return true;
    }
}

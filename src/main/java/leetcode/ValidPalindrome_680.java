package leetcode;

public class ValidPalindrome_680 {

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println("validPalindrome(s) = " + validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        for(int i =0,j=chars.length-1; i <=j; i++,j--) {
            if(chars[i] != chars[j]) {
                return isPalindrome(chars, i+1, j) || isPalindrome(chars, i, j-1);
            }
        }
        return true;
    }

    private static boolean isPalindrome(char[] chars, int start, int end) {
        for(int i =start, j=end; i <=j; i++,j--) {
            if(chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}

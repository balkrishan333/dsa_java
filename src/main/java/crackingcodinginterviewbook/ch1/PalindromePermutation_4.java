package crackingcodinginterviewbook.ch1;

public class PalindromePermutation_4 {

    public static void main(String[] args) {
        String str = "tact coa";

        boolean result = checkPermutation(str);
        System.out.println("result = " + result);
    }

    public static boolean checkPermutation(String str) {
        int[] charCount = new int[26];
        for(char ch : str.toCharArray()) {
            if (ch == ' ') { // ignore space
                continue;
            }
            charCount[ch-'a']++;
        }

        int charWithOddCount = 0;
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] % 2 != 0) {
                charWithOddCount++;
            }
        }
        return charWithOddCount <= 1;
    }
}

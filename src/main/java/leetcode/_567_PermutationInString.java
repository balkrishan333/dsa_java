package leetcode;

public class _567_PermutationInString {

    public static void main(String[] args) {
        _567_PermutationInString obj = new _567_PermutationInString();
        String s1 = "adc";
        String s2 = "dcda";

        boolean inclusion = obj.checkInclusion(s1, s2);
        System.out.println(inclusion);
    }

    public boolean checkInclusion(String s1, String s2) {

        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if (lenS1 > lenS2) {
            return false;
        }

        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();
        int[] charCount = new int[26];

        //lenS1 is smaller than or equal to lenS2
        for (int i = 0; i < lenS1; i++) {
            charCount[s1Arr[i]-'a']--;
            charCount[s2Arr[i]-'a']++;
        }

        if (allZero(charCount)) {
            return true;
        }

        //sliding window, we already traverse s2 partially (of size s1)
        //now use sliding window, keep size of window equal to length of s1
        for (int i = lenS1; i < lenS2; i++) {
            charCount[s2Arr[i]-'a']++; //increase count of incoming character in window
            charCount[s2Arr[i-lenS1]-'a']--; // decrease count of outgoing character from window

            if (allZero(charCount)) {
                return true;
            }
        }
        return false;
    }

    private boolean allZero(int[] charCount) {
        for (int j : charCount) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("unused")
    public boolean checkInclusion_v1(String s1, String s2) {
        int lenS1 = s1.length();

        char[] chars = s1.toCharArray();
        int[] charCount = new int[26];

        for (char aChar : chars) {
            charCount[aChar - 97]++;
        }

        int[] charCountCopy = charCount.clone();

        int startIndex = -1;
        for (int i = 0; i < s2.length(); i++) {
            int ch = s2.charAt(i)-97;
            if (charCountCopy[ch] > 0) {
                if (startIndex == -1) {
                    startIndex = i;
                }
                charCountCopy[ch]--;
                lenS1--;
                if (lenS1 == 0) {
                    return true;
                }
            } else if (lenS1 != s1.length()){
                lenS1 = s1.length(); // restore the length
                charCountCopy = charCount.clone();
                i = startIndex;
                startIndex = -1;
            }
        }
        return false;
    }
}

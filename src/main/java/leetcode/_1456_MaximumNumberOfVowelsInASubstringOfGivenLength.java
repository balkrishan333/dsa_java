package leetcode;

public class _1456_MaximumNumberOfVowelsInASubstringOfGivenLength {

    public static void main(String[] args) {
        _1456_MaximumNumberOfVowelsInASubstringOfGivenLength obj = new _1456_MaximumNumberOfVowelsInASubstringOfGivenLength();

        String s = "leetcode";
        int k = 3;
        System.out.println(obj.maxVowels(s, k));
    }

    /*
        Approach : Sliding window
     */
    public int maxVowels(String s, int k) {
        int startIndex = 0, endIndex = 0, count = 0, maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            endIndex = i;
            if (endIndex -startIndex +1 > k) {
                if (isVowel(s.charAt(startIndex))) {
                    count--;
                }
                startIndex++;
            }

            if (isVowel(s.charAt(i))) {
                count++;
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

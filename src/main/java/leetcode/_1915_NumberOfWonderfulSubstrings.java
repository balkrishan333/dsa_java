package leetcode;

public class _1915_NumberOfWonderfulSubstrings {

    public static void main(String[] args) {
        _1915_NumberOfWonderfulSubstrings obj = new _1915_NumberOfWonderfulSubstrings();

        String word = "aba";
        System.out.println(obj.wonderfulSubstrings(word));
    }

    public long wonderfulSubstrings(String word) {
        long answer = word.length();

        char[] chars = word.toCharArray();
        int[] charCount = new int[10]; //chars range from a-j
        for (char ch : chars) {
            charCount[ch-'a']++;
        }

        int charsWithOddCount = 0;
        for (int i = 0; i < 10; i++) {
            if (charCount[i] % 2 == 1) {
                charsWithOddCount++;
            }
        }

        if (charsWithOddCount <= 1) {
            answer++;
        }

        for (char ch : chars) {
            charCount[ch-'a']--;
            if (charCount[ch-'a'] % 2 == 1) {
                charsWithOddCount++;
            } else {
                charsWithOddCount--;
            }
            if (charsWithOddCount <= 1 && charCount[ch-'a'] > 1) {
                answer++;
            }
        }
        return answer;
    }
}

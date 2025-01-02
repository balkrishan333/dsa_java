package leetcode;

import java.util.Arrays;
import java.util.Set;

public class _2559_CountVowelStringsInRanges {

    public static void main(String[] args) {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        _2559_CountVowelStringsInRanges obj = new _2559_CountVowelStringsInRanges();

        System.out.println(Arrays.toString(obj.vowelStrings(words, queries)));
    }

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSum = new int[words.length+1];
        Arrays.fill(prefixSum, 0);

        for (int i = 0; i < words.length; i++) {
            prefixSum[i+1] = prefixSum[i] + countVowels(words[i]);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            answer[i] = prefixSum[query[1]+1] - prefixSum[query[0]];
        }
        return answer;
    }

    private int countVowels(String word) {

        if (word == null || word.isEmpty()) {
            return 0;
        }

        if (VOWELS.contains(word.charAt(0)) && VOWELS.contains(word.charAt(word.length()-1))) {
            return 1;
        }
        return 0;
    }
}

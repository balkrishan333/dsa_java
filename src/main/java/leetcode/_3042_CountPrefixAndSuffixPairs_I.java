package leetcode;

public class _3042_CountPrefixAndSuffixPairs_I {

    public static void main(String[] args) {
        _3042_CountPrefixAndSuffixPairs_I obj = new _3042_CountPrefixAndSuffixPairs_I();

        String[] words = {"a","aba","ababa","aa"};
        System.out.println(obj.countPrefixSuffixPairs(words));
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPrefixAndSuffix(String word, String word1) {

        int lengthWord = word.length();
        int lengthWord1 = word1.length();

        if (lengthWord1 < lengthWord) {
            return false;
        }
        
        return word1.substring(0, lengthWord).equals(word) && word1.substring(lengthWord1 - lengthWord).equals(word);
    }
}

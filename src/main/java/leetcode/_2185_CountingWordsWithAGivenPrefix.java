package leetcode;

public class _2185_CountingWordsWithAGivenPrefix {

    public static void main(String[] args) {
        _2185_CountingWordsWithAGivenPrefix obj = new _2185_CountingWordsWithAGivenPrefix();

        String[] words = {"pay","attention","practice","attend"};
        String perf = "at";
        System.out.println(obj.prefixCount(words, perf));
    }

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            //indexOf won't work as it would check existence of perf anywhere in string, but we need to check prefix
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }
}
